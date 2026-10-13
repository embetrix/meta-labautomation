SUMMARY = "Discover and inspect local Bluetooth adapters"
HOMEPAGE = "https://github.com/bluetooth-devices/bluetooth-adapters"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

inherit pypi python_poetry_core

SRC_URI[sha256sum] = "b6011cdaf68b6d075b5a90c85c5102844799fdc377758d78142a638c7b0c06fb"

PYPI_PACKAGE = "bluetooth_adapters"
UPSTREAM_CHECK_PYPI_PACKAGE = "bluetooth-adapters"

RDEPENDS:${PN} += " \
    python3-aiooui (>= 0.1.1) \
    python3-asyncio \
    python3-bleak (>= 1.0) \
    python3-ctypes \
    python3-dbus-fast (>= 1.21.0) \
    python3-fcntl \
    python3-logging \
    python3-uart-devices (>= 0.1.0) \
    python3-usb-devices (>= 0.4.5) \
"
