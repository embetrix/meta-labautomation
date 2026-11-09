# SPDX-License-Identifier: MIT
# Copyright 2026 Embetrix Embedded Systems Solutions <ayoub.zaki@embetrix.com>

SUMMARY = "FRITZ! power proxy for standard labgrid network power resources"
HOMEPAGE = "https://github.com/embetrix/labgrid-fritz"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0df35b9fe082cbe26460fe7a2ebbae32"

FILESEXTRAPATHS:prepend := "${THISDIR}/labgrid:"

SRC_URI = " \
    git://github.com/embetrix/labgrid-fritz.git;protocol=https;branch=main \
    file://fritz.json.example \
"
SRCREV = "f001cc0605b0535777c41e4f6a288925bb8bbd55"

inherit python_setuptools_build_meta systemd

SYSTEMD_SERVICE:${PN} = "labgrid-fritz.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

RDEPENDS:${PN} += " \
    openssh-ssh \
    python3-attrs \
    python3-core \
    python3-fritzconnection (>= 1.15.1) \
    python3-json \
    python3-labgrid (>= 26.0) \
    python3-logging \
    python3-math \
    python3-netclient \
    python3-netserver \
    rsync \
"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/examples/labgrid-fritz.service \
        ${D}${systemd_system_unitdir}/labgrid-fritz.service
    sed -i -e 's|/usr/bin/labgrid-fritz-proxy|${bindir}/labgrid-fritz-proxy|g' \
        -e 's|/etc/labgrid/|${sysconfdir}/labgrid/|g' \
        ${D}${systemd_system_unitdir}/labgrid-fritz.service

    install -d ${D}${sysconfdir}/labgrid
    install -m 0644 ${UNPACKDIR}/fritz.json.example \
        ${D}${sysconfdir}/labgrid/fritz.json.example

    install -d ${D}${datadir}/labgrid-fritz/examples
    install -m 0644 ${UNPACKDIR}/fritz.json.example \
        ${S}/examples/exporter.yaml \
        ${S}/examples/target.yaml \
        ${D}${datadir}/labgrid-fritz/examples/
}

# Ship configuration examples with the plugin, including images without -doc.
FILES:${PN} += " \
    ${systemd_system_unitdir}/labgrid-fritz.service \
    ${sysconfdir}/labgrid/fritz.json.example \
    ${datadir}/labgrid-fritz/examples \
"
