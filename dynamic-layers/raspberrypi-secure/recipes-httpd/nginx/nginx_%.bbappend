FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://labgrid-dashboard-location.conf"

do_install:append() {
    install -d ${D}${sysconfdir}/nginx/default-server.d
    install -m 0644 ${UNPACKDIR}/labgrid-dashboard-location.conf \
        ${D}${sysconfdir}/nginx/default-server.d/labgrid-dashboard-location.conf
}

FILES:${PN} += "${sysconfdir}/nginx/default-server.d/labgrid-dashboard-location.conf"
CONFFILES:${PN} += "${sysconfdir}/nginx/default-server.d/labgrid-dashboard-location.conf"
