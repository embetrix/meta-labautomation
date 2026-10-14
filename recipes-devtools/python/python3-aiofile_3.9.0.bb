SUMMARY = "Asynchronous file operations."
HOMEPAGE = "http://github.com/mosquito/aiofile"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENCE.md;md5=d8d1d59c60e60e8627fcd1c350a5c904"

inherit pypi python_poetry_core

SRC_URI[sha256sum] = "e5ad718bb148b265b6df1b3752c4d1d83024b93da9bd599df74b9d9ffcf7919b"

RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-caio \
"
