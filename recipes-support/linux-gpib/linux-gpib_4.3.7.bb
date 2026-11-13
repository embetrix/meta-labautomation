SUMMARY = "Linux GPIB library, tools and Python bindings"
HOMEPAGE = "https://linux-gpib.sourceforge.io/"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/linux-gpib/linux-gpib%20for%203.x.x%20and%202.6.x%20kernels/${PV}/linux-gpib-${PV}.tar.gz"
SRC_URI[sha256sum] = "b3ff812606865c85b58b012a4218a6fe3b82d177c8c0abc795cb22db41f3ad68"

S = "${UNPACKDIR}/linux-gpib-user-${PV}"

inherit autotools-brokensep pkgconfig setuptools3 useradd

DEPENDS += "bison-native flex-native ncurses readline"

# The release archive contains separate userspace and kernel archives
python do_unpack:append() {
    bb.process.run([
        "tar", "-xzf",
        d.expand("${UNPACKDIR}/linux-gpib-${PV}/linux-gpib-user-${PV}.tar.gz"),
        "-C", d.getVar("UNPACKDIR"),
    ])
}

# Build the Python bindings with Yocto's setuptools support instead of pip
SETUPTOOLS_SETUP_PATH = "${S}/language/python"
EXTRA_OECONF = " \
    --disable-all-bindings \
    --disable-documentation \
    --disable-html-docs \
    --disable-manpages \
    --with-udev-libdir=${nonarch_base_libdir}/udev \
"

# Configure checks host documentation paths even when documentation is disabled
CACHED_CONFIGUREVARS += " \
    ac_cv_file__usr_share_sgml_docbook_xsl_ns_stylesheets_manpages_docbook_xsl=no \
    ac_cv_file__usr_share_sgml_docbook_xsl_stylesheets_manpages_docbook_xsl=no \
    ac_cv_file__usr_share_xml_docbook_xsl_stylesheets_1_79_2_manpages_docbook_xsl=no \
"

do_configure() {
    autotools_do_configure
}

do_compile() {
    autotools_do_compile
    setuptools3_do_compile
}

do_install() {
    autotools_do_install
    setuptools3_do_install
}

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "--system gpib"

CONFFILES:${PN} += "${sysconfdir}/gpib.conf"
FILES:${PN} += "${nonarch_base_libdir}/udev ${datadir}/usb"
RDEPENDS:${PN} += "udev"
