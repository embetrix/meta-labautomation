SUMMARY = "Flashing, recovery and firmware updates"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    openocd \
    dfu-util \
    uuu \
    python3-snagboot \
    bmap-writer \
    bmaptool \
    python3-swupdateclient \
"
