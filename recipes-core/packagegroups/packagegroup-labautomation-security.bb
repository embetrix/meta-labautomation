SUMMARY = "Secure access and certificate support for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    ca-certificates \
    packagegroup-core-ssh-openssh \
"
