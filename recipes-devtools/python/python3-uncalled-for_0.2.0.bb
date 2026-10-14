SUMMARY = "Async dependency injection for Python functions"
HOMEPAGE = "https://github.com/chrisguidry/uncalled-for"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e08d7843536b59014e7932f734ce431c"

inherit pypi python_hatchling

SRC_URI[sha256sum] = "b4f8fdbcec328c5a113807d653e041c5094473dd4afa7c34599ace69ccb7e69f"

PYPI_PACKAGE = "uncalled_for"
UPSTREAM_CHECK_PYPI_PACKAGE = "uncalled-for"

DEPENDS += "python3-hatch-vcs-native python3-setuptools-scm-native"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-numbers \
"
