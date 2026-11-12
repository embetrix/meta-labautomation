SUMMARY = "Python VISA backend for Ethernet, USB and serial instruments"
HOMEPAGE = "https://github.com/pyvisa/pyvisa-py"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=13d0ed729c7823d870a87e050965654d"

PYPI_PACKAGE = "pyvisa_py"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "db53d3219d971d16b8f7c764a93e08475875063635b9ad8ea3c988439833ccdd"

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += " \
    libusb1 \
    python3-core \
    python3-ctypes \
    python3-io \
    python3-logging \
    python3-math \
    python3-netclient \
    python3-pyserial \
    python3-pyusb \
    python3-pyvisa (>= 1.15.0) \
    python3-threading \
    python3-typing-extensions \
"
