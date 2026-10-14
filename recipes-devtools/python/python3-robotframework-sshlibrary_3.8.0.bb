SUMMARY = "Robot Framework library for SSH and SFTP"
HOMEPAGE = "https://github.com/robotframework/SSHLibrary"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "aedf8a02bcb7344404cf8575d0ada25d6c7dc2fcb65de2113c4e07c63d2446c2"

RDEPENDS:${PN} += " \
    python3-io \
    python3-netserver \
    python3-paramiko \
    python3-robotframework \
    python3-scp \
    python3-shell \
    python3-threading \
"
