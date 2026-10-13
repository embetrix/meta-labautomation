SUMMARY = "High availability Bluetooth management"
HOMEPAGE = "https://github.com/bluetooth-devices/habluetooth"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da57f3e0372e39698a274746eb9d65d6"

inherit pypi python_poetry_core

SRC_URI[sha256sum] = "c0406141c3f3b08b68ab81a2e3ded29933c0b7608cec1a972253ebe921ff6359"

SRC_URI += "file://habluetooth-optional-cython.patch"

# Use the upstream-supported Python implementation; Cython acceleration is optional.
export SKIP_CYTHON = "1"
DEPENDS += "python3-setuptools-native"

RDEPENDS:${PN} += " \
    python3-async-interrupt (>= 1.1.1) \
    python3-asyncio \
    python3-bleak (>= 1.0.1) \
    python3-bleak-retry-connector (>= 4.0) \
    python3-bluetooth-adapters (>= 2.0) \
    python3-bluetooth-auto-recovery (>= 1.5.1) \
    python3-bluetooth-data-tools (>= 1.28.0) \
    python3-datetime \
    python3-dbus-fast (>= 2.30.2) \
    python3-logging \
"
