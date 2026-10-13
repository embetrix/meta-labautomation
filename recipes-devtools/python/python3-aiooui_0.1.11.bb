SUMMARY = "Asynchronous MAC address vendor lookup"
HOMEPAGE = "https://github.com/bluetooth-devices/aiooui"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c8ea148e26a1546c1b0a99524d4da3f7"

inherit pypi python_poetry_core

SRC_URI[sha256sum] = "737e1c605339a4ca3a860f0c60f1a35af0e256b44c93e8d0487ad62f3addeda8"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-mmap \
"
