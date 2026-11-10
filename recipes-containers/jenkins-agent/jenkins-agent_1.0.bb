# SPDX-License-Identifier: MIT
# Copyright 2026 Embetrix Embedded Systems Solutions <ayoub.zaki@embetrix.com>

SUMMARY = "Containerized Jenkins inbound agent with a labgrid client"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://Dockerfile \
    file://environment \
    file://jenkins-agent.service \
"

inherit allarch systemd

RDEPENDS:${PN} = "docker-moby volatile-binds"
SYSTEMD_SERVICE:${PN} = "jenkins-agent.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    install -d -m 0700 ${D}${sysconfdir}/jenkins-agent
    install -m 0600 ${UNPACKDIR}/environment ${D}${sysconfdir}/jenkins-agent/environment
    install -d ${D}${datadir}/jenkins-agent
    install -m 0644 ${UNPACKDIR}/Dockerfile ${D}${datadir}/jenkins-agent/Dockerfile
    install -d ${D}${systemd_system_unitdir}
    sed -e 's|@BINDIR@|${bindir}|g' \
        -e 's|@SYSCONFDIR@|${sysconfdir}|g' \
        -e 's|@DATADIR@|${datadir}|g' \
        ${UNPACKDIR}/jenkins-agent.service > ${D}${systemd_system_unitdir}/jenkins-agent.service
}

FILES:${PN} += "${datadir}/jenkins-agent"
CONFFILES:${PN} = "${sysconfdir}/jenkins-agent/environment"
