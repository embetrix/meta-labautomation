"""Check the recipe's nginx installation hook without changing host nginx."""
from pathlib import Path
import re
import subprocess
import tempfile

repo = Path(__file__).resolve().parents[2]
nginx_dir = repo / 'dynamic-layers/raspberrypi-secure/recipes-httpd/nginx'
recipe = (nginx_dir / 'nginx_%.bbappend').read_text()
body = re.search(r'labgrid_dashboard_install_proxy\(\) \{\n(.*?)\n\}', recipe, re.S)[1]
include = 'include /etc/nginx/labgrid-dashboard-location.conf;'

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
            ['sh', '-eu', '-c', 'bbfatal() { echo "$*" >&2; exit 1; }\n' + body],
            text=True, capture_output=True,
        )
    original = '''server {
    listen 443 ssl;
    ssl_certificate /etc/nginx/tls/controller.crt;
    ssl_certificate_key /etc/nginx/tls/controller.key;
    location /swupdate/ { proxy_pass http://127.0.0.1:8080/; }
}
server { listen 80; return 301 https://$host$request_uri; }
'''
    site.write_text(original)
    for _ in range(2):
        result = install()
        assert result.returncode == 0, result.stderr
    configured = site.read_text()
    assert configured.count(include) == 1
    assert configured.replace('    ' + include + '\n', '') == original
    print('PASS: HTTPS site retains its policy and receives exactly one include')
    site.write_text('server { listen 80; }\n')
    result = install()
    assert result.returncode != 0
    assert 'Dashboard requires an HTTPS' in result.stderr
    assert include not in site.read_text()
    print('PASS: HTTP-only site fails with an actionable error; no HTTP fallback')
