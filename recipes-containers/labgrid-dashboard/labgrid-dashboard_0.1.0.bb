SUMMARY = "Container deployment of the labgrid-plugins web dashboard"
HOMEPAGE = "https://tfcollins.github.io/labgrid-plugins/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

# Ship a pinned Docker build context; containers are built on the controller.
SRCREV = "e1088e62c0f8cd4688c7e92262b16798f28a78ad"
SRC_URI = " \
    git://github.com/tfcollins/labgrid-plugins.git;protocol=https;nobranch=1 \
    file://0001-configure-dashboard-for-labautomation.patch \
    file://0002-handle-telnet-serial-consoles.patch \
    file://0003-serve-dashboard-under-labgrid.patch \
    file://0004-enforce-console-ownership.patch \
    file://0005-connect-to-local-rest-power.patch \
    file://0006-read-only-console-watch.patch \
    file://compose.yaml \
    file://environment \
    file://nginx.conf \
    file://labgrid-dashboard.service \
"
inherit allarch systemd features_check
REQUIRED_DISTRO_FEATURES = "systemd"

RDEPENDS:${PN} = "docker-moby docker-compose nginx python3-labgrid-coordinator volatile-binds"
SYSTEMD_SERVICE:${PN} = "labgrid-dashboard.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d -m 0700 ${D}${sysconfdir}/labgrid-dashboard/ssh
    install -m 0600 ${UNPACKDIR}/environment ${D}${sysconfdir}/labgrid-dashboard/environment
    install -m 0644 ${UNPACKDIR}/nginx.conf ${D}${sysconfdir}/labgrid-dashboard/nginx.conf

    install -d ${D}${datadir}/labgrid-dashboard/source/coordinator
    cp -R --no-preserve=ownership ${S}/coordinator/api ${S}/coordinator/web \
        ${D}${datadir}/labgrid-dashboard/source/coordinator/
    cp -R --no-preserve=ownership ${S}/adi_lg_plugins \
        ${D}${datadir}/labgrid-dashboard/source/
    install -m 0644 ${S}/pyproject.toml ${S}/README.md ${S}/LICENSE \
        ${D}${datadir}/labgrid-dashboard/source/

    sed -e 's|@SYSCONFDIR@|${sysconfdir}|g' \
        ${UNPACKDIR}/compose.yaml > ${D}${datadir}/labgrid-dashboard/compose.yaml
    install -d ${D}${systemd_system_unitdir}
    sed -e 's|@BINDIR@|${bindir}|g' \
        -e 's|@SYSCONFDIR@|${sysconfdir}|g' \
        -e 's|@DATADIR@|${datadir}|g' \
        ${UNPACKDIR}/labgrid-dashboard.service > ${D}${systemd_system_unitdir}/labgrid-dashboard.service
}

FILES:${PN} += "${datadir}/labgrid-dashboard"
CONFFILES:${PN} = "${sysconfdir}/labgrid-dashboard/environment ${sysconfdir}/labgrid-dashboard/nginx.conf"
