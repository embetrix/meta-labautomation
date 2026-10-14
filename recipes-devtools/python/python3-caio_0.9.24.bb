SUMMARY = "Asynchronous file IO for Linux MacOS or Windows."
HOMEPAGE = "https://pypi.org/project/caio/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=5bfb72cbb53281574a4ccc9e7a5cc96f"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "5bcdecaea02a9aa8e3acf0364eff8ad9903d57d70cdb274a42270126290a77f1"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-multiprocessing \
"
