SUMMARY = "Packages for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    openocd \
    dfu-util \
    uhubctl \
    python3-aioshelly \
    python3-fritzconnection \
    python3-swupdateclient \
    python3-labgrid \
    python3-labgrid-coordinator \
    python3-labgrid-fritz \
    python3-powerrelay \
    python3-pyvisa \
    python3-pyvisa-py \
    python3-usbsdmux \
    python3-snagboot \
"
