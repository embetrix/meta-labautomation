SUMMARY = "Serial consoles and local hardware access"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    minicom \
    picocom \
    tio \
    ttyd \
    socat \
    usbutils \
    i2c-tools \
"
