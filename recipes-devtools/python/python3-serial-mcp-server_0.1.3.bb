SUMMARY = "MCP server for serial port access"
HOMEPAGE = "https://github.com/es617/serial-mcp-server"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3e888fe080a5efec49bddf393158fc52"

inherit pypi python_hatchling

PYPI_PACKAGE = "serial_mcp_server"
UPSTREAM_CHECK_PYPI_PACKAGE = "serial-mcp-server"

SRC_URI[sha256sum] = "722359e5891d4bfa39e14916bc92e53bddf4f38d5c653badf536ee340a936cc8"

DEPENDS += "python3-hatch-vcs-native python3-setuptools-scm-native"

RDEPENDS:${PN} += " \
    python3-anyio \
    python3-asyncio \
    python3-crypt \
    python3-datetime \
    python3-fcntl \
    python3-io \
    python3-json \
    python3-logging \
    python3-mcp (>= 1.23.0) \
    python3-mcp (< 2) \
    python3-netclient \
    python3-pyserial (>= 3.5) \
    python3-pyyaml \
    python3-shell \
    python3-stringold \
    python3-terminal \
    python3-threading \
"
