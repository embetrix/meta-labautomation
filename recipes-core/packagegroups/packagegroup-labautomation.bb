SUMMARY = "Packages for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    gitlab-runner \
    openocd \
    dfu-util \
    python3-labgrid \
    python3-powerrelay \
    python3-usbsdmux \
    python3-snagboot \
    python3-robotframework \
    python3-robotframework-seriallibrary \
"
