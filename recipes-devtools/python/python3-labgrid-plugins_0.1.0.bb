SUMMARY = "Labgrid plugins and MCP server for hardware workflows"
HOMEPAGE = "https://tfcollins.github.io/labgrid-plugins/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

# Use the same source revision as the labgrid dashboard
SRC_URI = "git://github.com/tfcollins/labgrid-plugins.git;protocol=https;nobranch=1"
SRCREV = "e1088e62c0f8cd4688c7e92262b16798f28a78ad"

inherit python_setuptools_build_meta

RDEPENDS:${PN} += " \
    libiio-python3 \
    python3-asyncio \
    python3-attrs \
    python3-click \
    python3-compression \
    python3-crypt \
    python3-ctypes \
    python3-datetime \
    python3-fastmcp \
    python3-io \
    python3-json \
    python3-labgrid (>= 26.0) \
    python3-logging \
    python3-math \
    python3-netclient \
    python3-netserver \
    python3-packaging \
    python3-pexpect \
    python3-pysnmp \
    python3-pyvesync (>= 1.1.5) \
    python3-pyvesync (< 3) \
    python3-pyyaml \
    python3-requests \
    python3-rich \
    python3-shell \
    python3-stringold \
    python3-threading \
    python3-tqdm \
    python3-unixadmin \
    python3-usbsdmux \
    python3-xml \
"
