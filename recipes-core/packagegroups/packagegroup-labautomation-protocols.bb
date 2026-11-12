SUMMARY = "Industrial protocols and messaging for lab automation"
LICENSE = "MIT"

# Library package names depend on the target architecture
PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

RDEPENDS:${PN} = " \
    can-utils \
    python3-can \
    libmodbus \
    mbpoll \
    python3-pymodbus \
    open62541 \
    mosquitto \
    mosquitto-clients \
    python3-paho-mqtt \
    zeromq \
    python3-pyzmq \
"
