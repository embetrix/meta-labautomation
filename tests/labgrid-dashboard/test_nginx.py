"""Check nginx fragment installation without changing host nginx"""
from pathlib import Path
import re
import subprocess
import tempfile

repo = Path(__file__).resolve().parents[2]
nginx_dir = repo / 'dynamic-layers/raspberrypi-secure/recipes-httpd/nginx'
recipe = (nginx_dir / 'nginx_%.bbappend').read_text()
body = re.search(r'do_install:append\(\) \{\n(.*?)\n\}', recipe, re.S)[1]

with tempfile.TemporaryDirectory(prefix='labgrid-nginx-test-') as tmp:
    site = Path(tmp) / 'etc/nginx/sites-available/default_server'
    site.parent.mkdir(parents=True)
    for key, value in {
        'D': tmp, 'sysconfdir': '/etc',
        'UNPACKDIR': str(nginx_dir / 'files'),
    }.items():
        body = body.replace('${' + key + '}', value)
    def install():
        return subprocess.run(
            ['sh', '-eu', '-c', body],
            text=True, capture_output=True,
        )
    original = '''server {
    listen 443 ssl;
    ssl_certificate /etc/nginx/tls/controller.crt;
    ssl_certificate_key /etc/nginx/tls/controller.key;
    include /etc/nginx/default-server.d/*.conf;
    location /swupdate/ { proxy_pass http://127.0.0.1:8080/; }
}
server { listen 80; return 301 https://$host$request_uri; }
'''
    site.write_text(original)
    for _ in range(2):
        result = install()
        assert result.returncode == 0, result.stderr
    assert site.read_text() == original
    fragments = list((Path(tmp) / 'etc/nginx/default-server.d').glob('*.conf'))
    assert len(fragments) == 1
    assert fragments[0].read_bytes() == (nginx_dir / 'files/labgrid-dashboard-location.conf').read_bytes()
    print('PASS: fragment installed in the included directory, existing site unchanged')
