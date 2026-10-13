SUMMARY = "Python interface for AVM FRITZ!Box and smart home devices"
HOMEPAGE = "https://github.com/kbr/fritzconnection"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=14e77f0736b95df3d3544d00d4894342"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "aa40b0a850f65fd7ea0483e65f733aa534d63c5e5bb9a8306c63e9dfd0bcf5dd"

RDEPENDS:${PN} += " \
    python3-crypt \
    python3-datetime \
    python3-html \
    python3-json \
    python3-logging \
    python3-math \
    python3-netclient \
    python3-pickle \
    python3-requests \
    python3-threading \
    python3-urllib3 \
    python3-xml \
"
