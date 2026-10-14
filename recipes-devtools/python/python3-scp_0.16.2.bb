SUMMARY = "SCP file transfers over a Paramiko SSH transport"
HOMEPAGE = "https://github.com/jbardin/scp.py"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=fc264c65fb17b7db5237cf7ce1780769"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "d049f9aa77db4042c44b922cecabe97ef0716fb334a95701d68d1c7991684fc2"

RDEPENDS:${PN} += " \
    python3-io \
    python3-paramiko \
"
