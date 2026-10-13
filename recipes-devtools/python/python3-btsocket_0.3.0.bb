SUMMARY = "Python interface to the BlueZ Bluetooth management API"
HOMEPAGE = "https://github.com/ukBaz/python-btsocket"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=363a8d5ecf81b0e022be8395c2a6986b"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "7ea495de0ff883f0d9f8eea59c72ca7fed492994df668fe476b84d814a147a0d"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-ctypes \
    python3-logging \
"
