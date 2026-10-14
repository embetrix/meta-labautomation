SUMMARY = "Modern, type-safe OpenAPI schemas in Python using Pydantic 1.8+ and 2.x"
HOMEPAGE = "https://github.com/mike-oakley/openapi-pydantic"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a863cea61cc05053f3fd021df6f8dc70"

inherit pypi python_hatchling

SRC_URI[sha256sum] = "11f3ac6ad41521fc156381ec587246b0c0ecea523bd9565ed74d3e7fac9d91cd"

PYPI_PACKAGE = "openapi_pydantic"
UPSTREAM_CHECK_PYPI_PACKAGE = "openapi-pydantic"

RDEPENDS:${PN} += " \
    python3-logging \
    python3-pydantic \
"
