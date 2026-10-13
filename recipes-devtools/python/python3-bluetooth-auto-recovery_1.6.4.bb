SUMMARY = "Recover unavailable Linux Bluetooth adapters"
HOMEPAGE = "https://github.com/bluetooth-devices/bluetooth-auto-recovery"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"

inherit pypi python_poetry_core

SRC_URI[sha256sum] = "c69a9f3b5e00239ab005d808aa5e7afa3c36a82f86e9531b6c7682bde1bc3ecc"

PYPI_PACKAGE = "bluetooth_auto_recovery"
UPSTREAM_CHECK_PYPI_PACKAGE = "bluetooth-auto-recovery"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-bluetooth-adapters (>= 0.16.0) \
    python3-btsocket (>= 0.2.0) \
    python3-fcntl \
    python3-logging \
    python3-pyric (>= 0.1.6.3) \
    python3-usb-devices (>= 0.4.1) \
"
