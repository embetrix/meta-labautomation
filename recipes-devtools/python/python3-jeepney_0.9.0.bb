SUMMARY = "Low-level, pure Python DBus protocol wrapper."
HOMEPAGE = "https://pypi.org/project/jeepney/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aad69c93f605003e3342b174d9b0708c"

inherit pypi python_flit_core

SRC_URI[sha256sum] = "cf0e9e845622b81e4a28df94c40345400256ec608d0e55bb8a3feaa9163f5732"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-io \
    python3-logging \
    python3-stringold \
    python3-threading \
    python3-xml \
"
