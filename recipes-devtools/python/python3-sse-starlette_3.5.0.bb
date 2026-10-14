SUMMARY = "SSE plugin for Starlette"
HOMEPAGE = "https://github.com/sysid/sse-starlette"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=512780230e4edd77125d98c5f52abafe"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "75de713aa8a9441513cc283220826da079d982770965b951e9437720e8bafdb2"

PYPI_PACKAGE = "sse_starlette"
UPSTREAM_CHECK_PYPI_PACKAGE = "sse-starlette"

RDEPENDS:${PN} += " \
    python3-anyio \
    python3-asyncio \
    python3-datetime \
    python3-json \
    python3-logging \
    python3-starlette \
"
