SUMMARY = "Robot Framework MCP Server - Natural Language Test Automation Bridge"
HOMEPAGE = "https://github.com/manykarim/rf-mcp"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

inherit pypi python_hatchling

SRC_URI[sha256sum] = "d3d8c19a24836edd480915b3a3311b4bd9bdf821be683eaf5b792f5a27fa96ab"

PYPI_PACKAGE = "rf_mcp"
UPSTREAM_CHECK_PYPI_PACKAGE = "rf-mcp"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-beautifulsoup4 \
    python3-crypt \
    python3-ctypes \
    python3-datetime \
    python3-difflib \
    python3-fastmcp \
    python3-io \
    python3-json \
    python3-logging \
    python3-lxml \
    python3-netclient \
    python3-netserver \
    python3-pydantic \
    python3-python-dotenv \
    python3-pyyaml \
    python3-robotframework \
    python3-sqlite3 \
    python3-statistics \
    python3-threading \
    python3-tomlkit \
    python3-xml \
"
