# SPDX-License-Identifier: MIT
# Copyright 2026 Embetrix Embedded Systems Solutions <ayoub.zaki@embetrix.com>

SUMMARY = "Labgrid power control for FRITZ! sockets via a remote lab host"
HOMEPAGE = "https://github.com/embetrix/labgrid-fritz"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0df35b9fe082cbe26460fe7a2ebbae32"

FILESEXTRAPATHS:prepend := "${THISDIR}/labgrid:"

SRC_URI = " \
    git://github.com/embetrix/labgrid-fritz.git;protocol=https;branch=main \
    file://fritz.json.example \
"
SRCREV = "0e3501f19a6662c2ef8d33df5c398cf6309951da"

inherit python_setuptools_build_meta

RDEPENDS:${PN} += " \
    openssh-ssh \
    python3-attrs \
    python3-core \
    python3-fritzconnection (>= 1.15.1) \
    python3-json \
    python3-labgrid (>= 26.0) \
    python3-math \
    rsync \
"

do_install:append() {
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
    ${sysconfdir}/labgrid/fritz.json.example \
    ${datadir}/labgrid-fritz/examples \
"
