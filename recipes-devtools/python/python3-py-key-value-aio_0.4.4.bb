SUMMARY = "Async Key-Value Store - A pluggable interface for KV Stores"
HOMEPAGE = "https://pypi.org/project/py-key-value-aio/"
LICENSE = "Apache-2.0"
# The sdist omits LICENSE; track the upstream license declaration instead.
LIC_FILES_CHKSUM = "file://pyproject.toml;beginline=7;endline=7;md5=b785a1f4e1ff6e5da7331358b80f813b"

inherit pypi python_pep517

SRC_URI[sha256sum] = "e3012e6243ed7cc09bb05457bd4d03b1ba5c2b1ca8700096b3927db79ffbbe55"

PYPI_PACKAGE = "py_key_value_aio"
UPSTREAM_CHECK_PYPI_PACKAGE = "py-key-value-aio"

DEPENDS += "python3-uv-build-native"

SRC_URI += "file://py-key-value-aio-uv-build-compatibility.patch"

# Include the storage extras required by FastMCP.
RDEPENDS:${PN} += " \
    python3-aiofile \
    python3-anyio \
    python3-asyncio \
    python3-beartype \
    python3-cachetools \
    python3-compression \
    python3-crypt \
    python3-datetime \
    python3-io \
    python3-json \
    python3-keyring \
    python3-logging \
    python3-netclient \
    python3-pydantic \
    python3-typing-extensions \
"
