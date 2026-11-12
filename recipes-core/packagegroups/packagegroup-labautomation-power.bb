SUMMARY = "Power switching and device connections"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    uhubctl \
    python3-powerrelay \
    python3-aioshelly \
    python3-fritzconnection \
    python3-labgrid-fritz \
    python3-usbsdmux \
"
