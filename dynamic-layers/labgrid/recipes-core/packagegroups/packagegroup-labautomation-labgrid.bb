SUMMARY = "Lab coordination and dashboard"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    python3-labgrid \
    python3-labgrid-coordinator \
    labgrid-dashboard \
"
