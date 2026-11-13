SUMMARY = "MCP servers for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    python3-robotframework-mcp \
    python3-serial-mcp-server \
"
