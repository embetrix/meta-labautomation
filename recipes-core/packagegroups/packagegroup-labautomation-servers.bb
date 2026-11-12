SUMMARY = "HTTP and TFTP servers for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    nginx \
    python3-flask \
    tftp-hpa-server \
"
