SUMMARY = "Simple, modern and high performance file watching and code reload in python."
HOMEPAGE = "https://github.com/samuelcolvin/watchfiles"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3c69d58fa5f4ff0b4244368d39546751"

inherit pypi python_maturin cargo-update-recipe-crates

SRC_URI[sha256sum] = "99aee4a07847c06820765fd7b1b49ceac4f3f711ccb7d104655a33231de1c207"

require ${BPN}-crates.inc

RDEPENDS:${PN} += " \
    python3-anyio \
    python3-asyncio \
    python3-json \
    python3-logging \
    python3-multiprocessing \
    python3-shell \
"
