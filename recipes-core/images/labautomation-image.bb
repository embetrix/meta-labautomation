SUMMARY = "base image for lab automation"
DESCRIPTION = "Base for adding lab automation tools and services"
LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL:append = " \
    labautomation-user \
    packagegroup-labautomation \
    packagegroup-labautomation-security \
    packagegroup-labautomation-tools \
    packagegroup-labautomation-devel \
    packagegroup-labautomation-middleware \
    packagegroup-labautomation-virtualization \
    packagegroup-labautomation-webserver \
"
