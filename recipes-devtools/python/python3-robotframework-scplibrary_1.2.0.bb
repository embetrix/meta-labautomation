SUMMARY = "Robot Framework library for transferring files via SCP"
HOMEPAGE = "https://github.com/tylercrumpton/robotframework-scplibrary"
LICENSE = "GPL-3.0-only"
# The source distribution omits LICENSE; use its package metadata declaration.
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=845e560ecc39395e8f142a154032aec7"

inherit pypi python_setuptools_build_meta

SRC_URI += "file://scplibrary-package-version.patch"
SRC_URI[sha256sum] = "0a10ab2335004f9dce867b917fd9d1738705896a6b3f552ed109212caf3cd9a1"

RDEPENDS:${PN} += " \
    python3-paramiko \
    python3-robotframework \
    python3-scp \
    python3-six \
"
