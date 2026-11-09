SUMMARY = "Robot Framework and test libraries for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    python3-robotframework \
    python3-robotframework-fritzhomelibrary \
    python3-robotframework-scplibrary \
    python3-robotframework-seriallibrary \
    python3-robotframework-sshlibrary \
    python3-robotframework-mcp \
"
