SUMMARY = "Intuitive, easy CLIs based on type hints."
HOMEPAGE = "https://github.com/BrianPugh/cyclopts"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4db124a215079420358276ea07be5a3e"

inherit pypi python_hatchling

SRC_URI[sha256sum] = "717ac4235548b58d500baf7e688aa4d024caf0ee68f61a012ffd5e29db3099f9"

DEPENDS += "python3-hatch-vcs-native python3-setuptools-scm-native"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-attrs \
    python3-datetime \
    python3-difflib \
    python3-docstring-parser \
    python3-io \
    python3-json \
    python3-rich \
    python3-rich-rst \
    python3-shell \
    python3-tomllib \
"
