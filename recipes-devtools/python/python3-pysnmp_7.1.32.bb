SUMMARY = "Python SNMP library"
HOMEPAGE = "https://github.com/lextudio/pysnmp"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=57ee828406c11080ad9bd7eabdc5ae1b"

inherit pypi python_flit_core

SRC_URI[sha256sum] = "b256e83513110b9f18011ed897e23652a7314c286910dbca87ba848289449ae3"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-crypt \
    python3-cryptography \
    python3-ctypes \
    python3-logging \
    python3-math \
    python3-netclient \
    python3-pyasn1 (>= 0.6.4) \
    python3-shell \
    python3-stringold \
"
