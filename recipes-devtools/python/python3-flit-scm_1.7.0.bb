SUMMARY = "A PEP 518 build backend that uses setuptools_scm to generate a version file from your version control system, then flit to build the package."
HOMEPAGE = "https://pypi.org/project/flit-scm/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=80f451d0892e64764fe22dbd241b5f02"

inherit pypi python_flit_core

SRC_URI[sha256sum] = "961bd6fb24f31bba75333c234145fff88e6de0a90fc0f7e5e7c79deca69f6bb2"

PYPI_PACKAGE = "flit_scm"
UPSTREAM_CHECK_PYPI_PACKAGE = "flit-scm"

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += " \
    python3-flit-core \
    python3-setuptools-scm \
    python3-tomllib \
"

BBCLASSEXTEND = "native"
