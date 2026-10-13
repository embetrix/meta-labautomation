SUMMARY = "Python client for uploading updates to SWUpdate devices"
HOMEPAGE = "https://github.com/sbabic/swupdate/tree/master/tools/python/swupdateclient"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/git/LICENSES/GPL-2.0-only.txt;md5=4ee23c52855c222cba72583d301d2338"

SRC_URI = " \
    git://github.com/sbabic/swupdate.git;protocol=https;branch=master;destsuffix=git \
    file://swupdateclient-termcolor-compatibility.patch \
    file://swupdateclient-package-discovery.patch \
"
SRCREV = "1a9325ba56bda69e20880a4232ae29b4be4eeab6"
PV = "0.1+git"

S = "${UNPACKDIR}/git/tools/python/swupdateclient"

inherit python_setuptools_build_meta

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-json \
    python3-logging \
    python3-netclient \
    python3-requests \
    python3-stringold \
    python3-termcolor (>= 2.2.0) \
    python3-urllib3 \
    python3-websockets \
"
