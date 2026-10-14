SUMMARY = "The ultimate Python library in building OAuth and OpenID Connect servers and clients."
HOMEPAGE = "https://pypi.org/project/Authlib/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ec053ca028e37ec79d3da3af34976d48"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "41ae180a17cf672bc784e4a518e5c82687f1fe1e98b0cafaeda80c8e4ab2d1cb"

RDEPENDS:${PN} += " \
    python3-crypt \
    python3-cryptography \
    python3-datetime \
    python3-json \
    python3-logging \
    python3-math \
    python3-netclient \
    python3-stringold \
"
