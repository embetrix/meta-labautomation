FILESEXTRAPATHS:prepend := "${THISDIR}/powerrelay:"

SRC_URI += "file://config.yaml"
RDEPENDS:${PN} += "python3-gpiod"

do_install:append() {
    install -d ${D}${sysconfdir}/powerrelay
    install -m 0644 ${UNPACKDIR}/config.yaml ${D}${sysconfdir}/powerrelay/config.yaml
}

CONFFILES:${PN} += "${sysconfdir}/powerrelay/config.yaml"
