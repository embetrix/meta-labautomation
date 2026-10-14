SUMMARY = "OpenTelemetry Python API"
HOMEPAGE = "https://github.com/open-telemetry/opentelemetry-python/tree/main/opentelemetry-api"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

inherit pypi python_hatchling

SRC_URI[sha256sum] = "aa38ed19bcc084ba42782a73255b3582283eced7ad6dddbd6695189e69adfb75"

PYPI_PACKAGE = "opentelemetry_api"
UPSTREAM_CHECK_PYPI_PACKAGE = "opentelemetry-api"

RDEPENDS:${PN} += " \
    python3-logging \
    python3-netclient \
    python3-numbers \
    python3-typing-extensions \
"
