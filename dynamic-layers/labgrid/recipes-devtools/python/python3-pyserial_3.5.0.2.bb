SUMMARY = "Serial port support with labgrid RFC2217 fixes"
HOMEPAGE = "https://github.com/labgrid-project/pyserial-labgrid"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=520e45e59fc2cf94aa53850f46b86436"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "pyserial-labgrid"
SRC_URI[sha256sum] = "98f826609795e92157ba2c2e9d8e98c6cec2f399de353f76dd0436536f5c52ab"

DEPENDS += "python3-setuptools-scm-native"

do_install:append() {
    rm -f ${D}${bindir}/pyserial-miniterm ${D}${bindir}/pyserial-ports
    rmdir ${D}${bindir}
}

PACKAGES =+ "${PN}-java ${PN}-osx ${PN}-win32 ${PN}-tools"

FILES:${PN}-java = " \
    ${PYTHON_SITEPACKAGES_DIR}/serial/*java* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/__pycache__/*java* \
"

FILES:${PN}-osx = " \
    ${PYTHON_SITEPACKAGES_DIR}/serial/*osx* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/__pycache__/*osx* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/*osx* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/__pycache__/*osx* \
"

FILES:${PN}-win32 = " \
    ${PYTHON_SITEPACKAGES_DIR}/serial/*serialcli* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/__pycache__/*serialcli* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/*win32* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/__pycache__/*win32* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/miniterm* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/__pycache__/miniterm* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/*windows* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/__pycache__/*windows* \
"

RDEPENDS:${PN} = " \
    python3-fcntl \
    python3-io \
    python3-logging \
    python3-netclient \
    python3-numbers \
    python3-shell \
    python3-stringold \
    python3-threading \
"

BBCLASSEXTEND = "native nativesdk"
