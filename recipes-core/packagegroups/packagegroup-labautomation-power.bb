SUMMARY = "Power switching and device connections"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    uhubctl \
    python3-aioshelly \
    python3-fritzconnection \
"
