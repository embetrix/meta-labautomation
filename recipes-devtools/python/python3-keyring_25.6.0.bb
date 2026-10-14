SUMMARY = "Store and access your passwords safely."
HOMEPAGE = "https://pypi.org/project/keyring/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=141643e11c48898150daa83802dbc65f"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "0b39998aa941431eb3d9b0d4b2460bc773b9df6fed7621c2dfb291a7e0187a66"

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += " \
    python3-ctypes \
    python3-jaraco-classes \
    python3-jaraco-context \
    python3-jaraco-functools \
    python3-jeepney \
    python3-json \
    python3-logging \
    python3-math \
    python3-secretstorage \
    python3-stringold \
    python3-unixadmin \
"
