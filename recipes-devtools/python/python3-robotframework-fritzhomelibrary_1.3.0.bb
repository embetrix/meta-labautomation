SUMMARY = "Robot Framework library for AVM FRITZ!Box home automation"
HOMEPAGE = "https://github.com/oeick/robotframework-fritzhomelibrary"
LICENSE = "MIT"
# The source distribution omits LICENSE; use the upstream license classifier.
LIC_FILES_CHKSUM = "file://setup.py;beginline=19;endline=19;md5=6b8498459670618172a8419b5f7f8576"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "55f6f213f4c4c1c33a0657dcbe0f03388659f3b834f12c26791f4385d05520fc"

RDEPENDS:${PN} += " \
    python3-crypt \
    python3-requests \
    python3-robotframework \
    python3-xml \
"
