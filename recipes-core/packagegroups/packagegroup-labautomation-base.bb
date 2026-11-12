SUMMARY = "User account and everyday tools for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    labautomation-user \
    bash \
    tmux \
    htop \
    curl \
    rsync \
    volatile-binds \
"
