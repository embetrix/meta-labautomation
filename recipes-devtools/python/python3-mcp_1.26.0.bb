SUMMARY = "Model Context Protocol SDK"
HOMEPAGE = "https://modelcontextprotocol.io"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7ae711d8a91d3871696f50e34ad3c2d7"

inherit pypi python_hatchling

SRC_URI[sha256sum] = "db6e2ef491eecc1a0d93711a76f28dec2e05999f93afd48795da1c1137142c66"

DEPENDS += "python3-uv-dynamic-versioning-native"

# Release archives do not contain the Git metadata used by the version hook.
export UV_DYNAMIC_VERSIONING_BYPASS = "${PV}"

RDEPENDS:${PN} += " \
    python3-anyio \
    python3-crypt \
    python3-cryptography \
    python3-datetime \
    python3-httpx \
    python3-httpx-sse \
    python3-json \
    python3-jsonschema \
    python3-logging \
    python3-netclient \
    python3-numbers \
    python3-pydantic \
    python3-pydantic-settings \
    python3-pyjwt \
    python3-python-dotenv \
    python3-python-multipart \
    python3-sse-starlette \
    python3-starlette \
    python3-stringold \
    python3-typer \
    python3-typing-extensions \
    python3-typing-inspection \
    python3-uvicorn \
"
