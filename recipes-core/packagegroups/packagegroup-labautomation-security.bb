SUMMARY = "Secure access and certificate support for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    ca-certificates \
    wireguard-tools \
    packagegroup-core-ssh-openssh \
"
