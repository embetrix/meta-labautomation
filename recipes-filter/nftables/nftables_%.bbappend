FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://rules.d/50-labgrid.nft \
    file://rules.d/50-fritzautomation.nft \
"

do_install:append() {
    install -d ${D}${sysconfdir}/nftables/rules.d
    install -m 0644 ${UNPACKDIR}/rules.d/50-labgrid.nft \
        ${D}${sysconfdir}/nftables/rules.d/50-labgrid.nft
    install -m 0644 ${UNPACKDIR}/rules.d/50-fritzautomation.nft \
        ${D}${sysconfdir}/nftables/rules.d/50-fritzautomation.nft
}

# Run after all layers' install appends have installed the base ruleset.
do_install[postfuncs] += "labautomation_nftables_include"
labautomation_nftables_include() {
    if [ -f ${D}${sysconfdir}/nftables/firewall.nft ]; then
        if ! grep -Fqx 'include "${sysconfdir}/nftables/rules.d/*.nft"' ${D}${sysconfdir}/nftables/firewall.nft; then
            printf '\ninclude "${sysconfdir}/nftables/rules.d/*.nft"\n' >> ${D}${sysconfdir}/nftables/firewall.nft
        fi
    fi
}

FILES:${PN} += " \
    ${sysconfdir}/nftables/rules.d/50-labgrid.nft \
    ${sysconfdir}/nftables/rules.d/50-fritzautomation.nft \
"
