FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://rules.d/50-labgrid.nft"

do_install:append() {
    install -d ${D}${sysconfdir}/nftables/rules.d
    install -m 0644 ${UNPACKDIR}/rules.d/50-labgrid.nft \
        ${D}${sysconfdir}/nftables/rules.d/50-labgrid.nft
}

FILES:${PN} += "${sysconfdir}/nftables/rules.d/50-labgrid.nft"
