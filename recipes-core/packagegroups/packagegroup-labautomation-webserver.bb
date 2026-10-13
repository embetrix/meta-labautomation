SUMMARY = "HTTP and TFTP servers for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    nginx \
    tftp-hpa-server \
"
