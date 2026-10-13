SUMMARY = "Python interface to Linux wireless configuration"
HOMEPAGE = "http://wraith-wireless.github.io/PyRIC/"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a756f433cda3b32df08555bc02207cc1"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "b539b01cafebd2406c00097f94525ea0f8ecd1dd92f7731f43eac0ef16c2ccc9"

PYPI_PACKAGE = "PyRIC"

RDEPENDS:${PN} += " \
    python3-datetime \
    python3-fcntl \
    python3-json \
    python3-math \
    python3-netclient \
"
