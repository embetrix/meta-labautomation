SUMMARY = "Interrupt an asynchronous task with an exception"
HOMEPAGE = "https://github.com/bluetooth-devices/async_interrupt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da57f3e0372e39698a274746eb9d65d6"

inherit pypi python_poetry_core

SRC_URI[sha256sum] = "be4331a029b8625777905376a6dc1370984c8c810f30b79703f3ee039d262bf7"

PYPI_PACKAGE = "async_interrupt"
UPSTREAM_CHECK_PYPI_PACKAGE = "async-interrupt"

RDEPENDS:${PN} += " \
    python3-asyncio \
"
