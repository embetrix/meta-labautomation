SUMMARY = "Network configuration and testing for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    ethtool \
    iproute2 \
    iputils \
    iperf3 \
    tcpdump \
    nmap \
    python3-scapy \
    ettercap \
    tcpreplay \
"
