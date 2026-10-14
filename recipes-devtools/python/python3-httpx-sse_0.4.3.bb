SUMMARY = "Consume Server-Sent Event (SSE) messages with HTTPX."
HOMEPAGE = "https://github.com/florimondmanca/httpx-sse"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=847662516af24b720ff6168b0dfcc6b1"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "9b1ed0127459a66014aec3c56bebd93da3c1bc8bb6618c8082039a44889a755d"

PYPI_PACKAGE = "httpx_sse"
UPSTREAM_CHECK_PYPI_PACKAGE = "httpx-sse"

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += " \
    python3-httpx \
    python3-json \
"
