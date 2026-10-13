SUMMARY = "Reliable connection handling for Bleak Bluetooth clients"
HOMEPAGE = "https://github.com/bluetooth-devices/bleak-retry-connector"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"

inherit pypi python_poetry_core

SRC_URI[sha256sum] = "0645ca814fe9e0f2e0716ffdae5e54de25de75de6197145a1784f20f58e76844"

PYPI_PACKAGE = "bleak_retry_connector"
UPSTREAM_CHECK_PYPI_PACKAGE = "bleak-retry-connector"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-bleak (>= 2.0) \
    python3-bluetooth-adapters (>= 0.15.2) \
    python3-dbus-fast (>= 1.14.0) \
    python3-logging \
"
