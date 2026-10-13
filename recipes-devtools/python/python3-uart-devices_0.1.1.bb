SUMMARY = "Discover UART device information from Linux sysfs"
HOMEPAGE = "https://github.com/bluetooth-devices/uart-devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c8ea148e26a1546c1b0a99524d4da3f7"

inherit pypi python_poetry_core

SRC_URI[sha256sum] = "3a52c4ae0f5f7400ebe1ae5f6e2a2d40cc0b7f18a50e895236535c4e53c6ed34"

PYPI_PACKAGE = "uart_devices"
UPSTREAM_CHECK_PYPI_PACKAGE = "uart-devices"

RDEPENDS:${PN} += " \
    python3-asyncio \
"
