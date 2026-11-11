SUMMARY = "HTTP and TFTP servers for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    nginx \
    labgrid-dashboard \
    python3-flask \
    tftp-hpa-server \
"
