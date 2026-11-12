SUMMARY = "MCP servers for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    python3-labgrid-mcp \
    python3-labgrid-plugins \
    python3-robotframework-mcp \
    python3-serial-mcp-server \
"
