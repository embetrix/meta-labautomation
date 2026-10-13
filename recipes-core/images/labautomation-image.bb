SUMMARY = "base image for lab automation"
DESCRIPTION = "Base for adding lab automation tools and services"
LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    packagegroup-labautomation \
    packagegroup-labautomation-security \
    packagegroup-labautomation-tools \
    packagegroup-labautomation-devel \
    ${CORE_IMAGE_EXTRA_INSTALL} \
"
