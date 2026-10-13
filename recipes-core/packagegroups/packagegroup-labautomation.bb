SUMMARY = "Packages for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    gitlab-runner \
    github-runner \
    openocd \
    dfu-util \
    uhubctl \
    python3-aioshelly \
    python3-fritzconnection \
    python3-swupdateclient \
    python3-labgrid \
    python3-powerrelay \
    python3-usbsdmux \
    python3-snagboot \
    python3-robotframework \
    python3-robotframework-seriallibrary \
"
