SUMMARY = "Container runtime for lab automation"
LICENSE = "MIT"

inherit packagegroup features_check

REQUIRED_DISTRO_FEATURES = "virtualization seccomp ipv6"

# Wrynose provides the Docker engine and CLI through docker-moby.
RDEPENDS:${PN} = " \
    docker-moby \
"
