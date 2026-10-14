SUMMARY = "Backport of PEP 654 (exception groups)"
HOMEPAGE = "https://pypi.org/project/exceptiongroup/"
LICENSE = "MIT & PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d5caa317463c433575efff1d2fe206d7"

inherit pypi python_flit_core

SRC_URI[sha256sum] = "b241f5885f560bc56a59ee63ca4c6a8bfa46ae4ad651af316d4e81817bb9fd88"

DEPENDS += "python3-flit-scm-native"
