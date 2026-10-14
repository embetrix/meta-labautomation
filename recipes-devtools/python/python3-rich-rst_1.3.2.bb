SUMMARY = "A beautiful reStructuredText renderer for rich"
HOMEPAGE = "https://wasi-master.github.io/rich-rst"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=58272f746ead52d3a904553c93737473"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "a1196fdddf1e364b02ec68a05e8ff8f6914fee10fbca2e6b6735f166bb0da8d4"

PYPI_PACKAGE = "rich_rst"
UPSTREAM_CHECK_PYPI_PACKAGE = "rich-rst"

RDEPENDS:${PN} += " \
    python3-docutils \
    python3-html \
    python3-rich \
"
