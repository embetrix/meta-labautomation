SUMMARY = "Tools for decoding Bluetooth data and packets"
HOMEPAGE = "https://github.com/bdraco/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

inherit pypi python_poetry_core

SRC_URI[sha256sum] = "ebfb3ff006da96cc34769e8b4d7b05982db5dd85b7dd7dda7ece9fa1fc34f352"

SRC_URI += "file://bluetooth-data-tools-optional-cython.patch"

PYPI_PACKAGE = "bluetooth_data_tools"
UPSTREAM_CHECK_PYPI_PACKAGE = "bluetooth-data-tools"

# Use the upstream-supported Python implementation; Cython acceleration is optional.
export SKIP_CYTHON = "1"
DEPENDS += "python3-setuptools-native"

RDEPENDS:${PN} += " \
    python3-cryptography (>= 41.0.3) \
    python3-logging \
"
