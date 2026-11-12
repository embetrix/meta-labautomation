SUMMARY = "Python client for VeSync smart devices"
HOMEPAGE = "https://github.com/webdjoe/pyvesync"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ab8e3279dfed717cfb84bf6e6931573b"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "744ad41f4dcaba2ce6e1eacf8bfa6bd2e5570349dad350e116ca36c98bc51fba"

# Labgrid plugins use the synchronous VeSync 2.x API
RDEPENDS:${PN} += " \
    python3-crypt \
    python3-image \
    python3-json \
    python3-logging \
    python3-requests \
"
