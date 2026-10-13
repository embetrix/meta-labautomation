SUMMARY = "Shell, network and USB tools for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    bash \
    bmap-writer \
    bmaptool \
    curl \
    ethtool \
    iproute2 \
    iputils \
    usbutils \
    uuu \
    minicom \
    ttyd \
    can-utils \
    socat \
    rsync \
    tcpdump \
    i2c-tools \
    python3-swupdateclient \
"
