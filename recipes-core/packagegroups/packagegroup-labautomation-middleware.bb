SUMMARY = "Industrial protocols and messaging for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    libmodbus \
    mbpoll \
    python3-pymodbus \
    open62541 \
    mosquitto \
    mosquitto-clients \
    python3-paho-mqtt \
    zeromq \
    python3-pyzmq \
    python3-can \
"
