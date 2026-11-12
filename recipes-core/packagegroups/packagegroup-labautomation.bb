SUMMARY = "All lab automation package groups"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    packagegroup-labautomation-base \
    packagegroup-labautomation-labgrid \
    packagegroup-labautomation-power \
    packagegroup-labautomation-flashing \
    packagegroup-labautomation-hardware \
    packagegroup-labautomation-instruments \
    packagegroup-labautomation-protocols \
    packagegroup-labautomation-robotframework \
    packagegroup-labautomation-mcp \
    packagegroup-labautomation-ci \
    packagegroup-labautomation-containers \
    packagegroup-labautomation-servers \
    packagegroup-labautomation-remote-access \
    packagegroup-labautomation-network \
    packagegroup-labautomation-debug \
"
