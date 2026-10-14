SUMMARY = "The fast, Pythonic way to build MCP servers and clients."
HOMEPAGE = "https://gofastmcp.com"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2b42edef8fa55315f34f2370b4715ca9"

inherit pypi python_hatchling

SRC_URI[sha256sum] = "db184b5391a31199323766a3abf3a8bfbb8010479f77eca84c0e554f18655c48"

DEPENDS += "python3-uv-dynamic-versioning-native"

# Release archives do not contain the Git metadata used by the version hook.
export UV_DYNAMIC_VERSIONING_BYPASS = "${PV}"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-authlib \
    python3-crypt \
    python3-cyclopts \
    python3-datetime \
    python3-difflib \
    python3-email \
    python3-email-validator \
    python3-exceptiongroup \
    python3-html \
    python3-httpx \
    python3-io \
    python3-json \
    python3-jsonref \
    python3-jsonschema-path \
    python3-logging \
    python3-mcp \
    python3-multiprocessing \
    python3-netclient \
    python3-numbers \
    python3-openapi-pydantic \
    python3-opentelemetry-api \
    python3-packaging \
    python3-platformdirs \
    python3-py-key-value-aio \
    python3-pydantic \
    python3-pyperclip \
    python3-python-dotenv \
    python3-pyyaml \
    python3-rich \
    python3-shell \
    python3-uncalled-for \
    python3-uvicorn \
    python3-watchfiles \
    python3-websockets \
"
