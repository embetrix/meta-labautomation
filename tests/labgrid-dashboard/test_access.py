"""Run in the built API image, mounted as /app/test_access.py, with --network none.

Uses a temporary labgrid coordinator and simulated UART; never contacts hardware.
"""
import os
import socket
import socketserver
import subprocess
import tempfile
import threading
import time

os.environ.update(
    LG_DATABASE_PATH='/tmp/access-test.db', LG_RECORDINGS_DIR='/tmp/recordings',
    LG_INITIAL_ADMIN_USERNAME='admin', LG_INITIAL_ADMIN_PASSWORD='test-only-password-1234',
    LG_SESSION_COOKIE_SECURE='true', LG_COORDINATOR_ADDRESS='127.0.0.1:20408',
)
from fastapi.testclient import TestClient
from starlette.websockets import WebSocketDisconnect
from labgrid.remote.common import ResourceEntry, ResourceMatch
from app.main import app


class Serial(socketserver.BaseRequestHandler):
    def handle(self):
        self.request.settimeout(5)
        self.request.sendall(b'DUT console> ')
        if self.request.recv(100) == b'version\r':
            self.request.sendall(b'U-Boot test\r\n')


def check_access(client):
    def post(path, data=None, status=200):
        response = client.post('/api' + path, json=data)
        assert response.status_code == status, (path, response.status_code, response.text)
        return response

    password = 'test-only-password-1234'
    post('/auth/login', {'username': 'admin', 'password': password})
    for user in ['operator1', 'operator2']:
        post('/users', {'username': user, 'password': password, 'role': 'user'}, 201)
    post('/auth/login', {'username': 'operator1', 'password': password})
    post('/places', {'name': 'dut'}, 201)
    post('/places/dut/acquire')
    coordinator = app.state.coordinator
    manager = app.state.console_manager
    manager.grace_seconds = 0.2
    path = ('exporter', 'hardware', 'NetworkSerialPort', 'uart')

    with socketserver.TCPServer(('127.0.0.1', 0), Serial) as serial:
        thread = threading.Thread(target=serial.serve_forever, daemon=True)
        thread.start()
        try:
            entry = ResourceEntry({
                'cls': 'NetworkSerialPort', 'avail': True, 'acquired': 'other-place',
                'params': {'host': '127.0.0.1', 'port': serial.server_address[1], 'protocol': 'raw'},
            })
            # Simulate exporter updates in the API's cache; keep real get_resource().
            coordinator._resources = {'exporter': {'hardware': {'uart': entry}}}
            assert coordinator.get_resource('dut', 'uart') is None
            try:
                with client.websocket_connect('wss://testserver/api/places/dut/resources/uart/console'):
                    raise AssertionError('unrelated resource accepted')
            except WebSocketDisconnect:
                pass
            print('PASS: unrelated UART denied to a normal user', flush=True)

            place = coordinator._places['dut']
            place.matches = [ResourceMatch(exporter='exp*', group='hard*', cls='NetworkSerialPort', name='u*', rename='console')]
            place.acquired_resources = [path]
            assert coordinator.get_resource('dut', 'console') is None  # wrong owning place
            entry.data['acquired'] = 'dut'
            assert coordinator.get_resource('dut', 'console') is not None
            assert coordinator.get_resource('dut', 'uart') is None  # must use renamed name
            place.acquired_resources = []
            assert coordinator.get_resource('dut', 'console') is None  # matching isn't ownership
            place.acquired_resources = [path]
            owner = place.acquired
            place.acquired = 'another-host/another-client'
            assert coordinator.get_resource('dut', 'console') is None
            place.acquired = owner
            coordinator._connected_event.clear()
            assert coordinator.get_resource('dut', 'console') is None
            coordinator._connected_event.set()
            with client.websocket_connect('wss://testserver/api/places/dut/resources/console/console') as ws:
                assert ws.receive_bytes() == b'DUT console> '
                ws.send_bytes(b'version\r')
                assert ws.receive_bytes() == b'U-Boot test\r\n'
            print('PASS: acquired wildcard/renamed UART works; stale and wrong-owner resources denied', flush=True)
            time.sleep(0.4)
            assert client.get('/api/places/dut').json()['acquired_username'] == 'operator1'
            assert manager.get('dut', 'console') is None
            print('PASS: console timeout cleans its session without releasing the place', flush=True)

            # Recreate a pending old console cleanup and transfer ownership before it runs.
            manager.grace_seconds = 1.0
            client.portal.call(manager.arm_grace, 'dut', 'console')
            post('/places/dut/release')
            post('/auth/login', {'username': 'operator2', 'password': password})
            post('/places/dut/acquire')
            time.sleep(1.2)
            state = client.get('/api/places/dut').json()
            assert state['acquired_username'] == 'operator2' and state['acquired']
            post('/places/dut/release')
            print('PASS: stale console cleanup cannot release the next user acquisition', flush=True)
        finally:
            serial.shutdown()
            thread.join(2)


with tempfile.TemporaryDirectory() as directory:
    with open('/tmp/access-coordinator.log', 'w') as log:
        coordinator_process = subprocess.Popen(
            ['labgrid-coordinator', '--listen', '127.0.0.1:20408'],
            cwd=directory, stdout=log, stderr=log,
        )
        try:
            for _ in range(100):
                try:
                    with socket.create_connection(('127.0.0.1', 20408), 0.1):
                        break
                except OSError:
                    time.sleep(0.1)
            else:
                raise AssertionError('test coordinator failed to start')
            with TestClient(app, base_url='https://testserver', root_path='/labgrid') as client:
                check_access(client)
        finally:
            coordinator_process.terminate()
            coordinator_process.wait(timeout=5)
