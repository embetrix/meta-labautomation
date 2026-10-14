SUMMARY = "Dynamic versioning based on VCS tags for uv/hatch project"
HOMEPAGE = "https://github.com/ninoseki/uv-dynamic-versioning/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=14d953809f6381e54162e13c2c846fbc"

inherit pypi python_hatchling

SRC_URI[sha256sum] = "4c785ea02e00b93896d015fd3613c451735af1715a7f5f52e8e4e1d76e6ec3c5"

PYPI_PACKAGE = "uv_dynamic_versioning"
UPSTREAM_CHECK_PYPI_PACKAGE = "uv-dynamic-versioning"

DEPENDS += "python3-dunamai-native python3-jinja2-native python3-tomlkit-native"

RDEPENDS:${PN} += " \
    python3-datetime \
    python3-dunamai \
    python3-hatchling \
    python3-jinja2 \
    python3-tomlkit \
"

BBCLASSEXTEND = "native"
