SUMMARY = "JSONSchema Spec with object-oriented paths"
HOMEPAGE = "https://github.com/p1c2u/jsonschema-path"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

inherit pypi python_poetry_core

SRC_URI[sha256sum] = "493b156ba895c97602655b620a8456caa2ce08c1aa389f5a7addec065e6e855c"

PYPI_PACKAGE = "jsonschema_path"
UPSTREAM_CHECK_PYPI_PACKAGE = "jsonschema-path"

RDEPENDS:${PN} += " \
    python3-attrs \
    python3-json \
    python3-netclient \
    python3-pathable \
    python3-pyyaml \
    python3-referencing \
"
