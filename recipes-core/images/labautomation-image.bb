SUMMARY = "base image for lab automation"
DESCRIPTION = "Base for adding lab automation tools and services"
LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL:append = " \
    packagegroup-labautomation \
"
