SUMMARY = "SSH, VPN access and certificates for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    packagegroup-core-ssh-openssh \
    wireguard-tools \
    tailscale \
    openvpn \
"
