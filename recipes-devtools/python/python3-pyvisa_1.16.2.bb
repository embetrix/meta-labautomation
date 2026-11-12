SUMMARY = "Python interface for VISA test and measurement instruments"
HOMEPAGE = "https://github.com/pyvisa/pyvisa"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9ba056c6d31855549ccb3cf61dedcd99"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "75beb93eeafe20a50be5726fa4e3a645948c93d86819f9c1f8c542efa4085a38"

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += " \
    python3-core \
    python3-ctypes \
    python3-html \
    python3-io \
    python3-json \
    python3-logging \
    python3-math \
    python3-shell \
    python3-threading \
    python3-typing-extensions \
"
