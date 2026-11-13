SUMMARY = "MCP server for labgrid device control"
HOMEPAGE = "https://github.com/onurcelep/labgrid-mcp"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

inherit pypi python_hatchling

PYPI_PACKAGE = "labgrid_mcp"
UPSTREAM_CHECK_PYPI_PACKAGE = "labgrid-mcp"

SRC_URI[sha256sum] = "7aa83f932291dfc3a30ad8ea787253482638c3322331bd1a4860a25d9ea0cf18"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-grpcio (>= 1.60) \
    python3-json \
    python3-labgrid (>= 26.0) \
    python3-labgrid (< 27) \
    python3-logging \
    python3-mcp (>= 1.2) \
    python3-mcp (< 2) \
    python3-netclient \
    python3-netserver \
    python3-pexpect \
    python3-pydantic \
    python3-shell \
    python3-threading \
    python3-unixadmin \
"
