FILESEXTRAPATHS:prepend := "${THISDIR}/labgrid:"

SRC_URI += " \
    file://exporter.conf \
    file://labgrid-tmpfiles.conf \
"

# systemd.bbclass only processes services in SYSTEMD_PACKAGES, including splits.
SYSTEMD_PACKAGES = "${PN} ${PN}-coordinator"
RDEPENDS:${PN}:append = " labautomation-user volatile-binds"

do_install:append() {
    sed -i \
        -e 's/^After=network-online.target$/After=network.target/' \
        -e '/^Wants=network-online.target$/d' \
        ${D}${systemd_system_unitdir}/labgrid-exporter.service

    install -d ${D}${systemd_system_unitdir}/labgrid-exporter.service.d
    install -m 0644 ${UNPACKDIR}/exporter.conf ${D}${systemd_system_unitdir}/labgrid-exporter.service.d/10-labautomation.conf
    install -d ${D}${nonarch_libdir}/tmpfiles.d
    install -m 0644 ${UNPACKDIR}/labgrid-tmpfiles.conf ${D}${nonarch_libdir}/tmpfiles.d/labgrid.conf

    # Bind targets must exist before volatile-binds runs on a read-only rootfs.
    install -d -m 0700 ${D}${localstatedir}/lib/private
    install -d -m 0700 ${D}${localstatedir}/lib/private/labgrid-coordinator
    install -d ${D}${localstatedir}/cache/labgrid
}

FILES:${PN}-coordinator += "${localstatedir}/lib/private"
FILES:${PN} += "${nonarch_libdir}/tmpfiles.d/labgrid.conf"
CONFFILES:${PN} += "${sysconfdir}/labgrid/configuration.yaml ${sysconfdir}/labgrid/environment"
