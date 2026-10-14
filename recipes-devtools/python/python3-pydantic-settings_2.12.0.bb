SUMMARY = "Settings management using Pydantic"
HOMEPAGE = "https://github.com/pydantic/pydantic-settings"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9adde1a30a7e74a03e57e456551c19ae"

inherit pypi python_hatchling

SRC_URI[sha256sum] = "005538ef951e3c2a68e1c08b292b5f2e71490def8589d4221b95dab00dafcfd0"

PYPI_PACKAGE = "pydantic_settings"
UPSTREAM_CHECK_PYPI_PACKAGE = "pydantic-settings"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-json \
    python3-pydantic \
    python3-python-dotenv \
    python3-shell \
    python3-tomllib \
    python3-typing-inspection \
"
