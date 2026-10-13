SUMMARY = "Asynchronous control of Shelly Gen1, Gen2, Gen3 and Gen4 devices"
HOMEPAGE = "https://github.com/home-assistant-libs/aioshelly"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "bc4dd1499a113f8957409be6a66072c3b0a8a2c66bdea218afea94e5d93b9ca2"

# 13.25.0 supports Gen3/Gen4 and the aiohttp 3.13 series in wrynose.
# aioshelly 13.34.1 requires aiohttp >= 3.14.

RDEPENDS:${PN} += " \
    python3-aiohttp (>= 3.11.1) \
    python3-asyncio \
    python3-bleak \
    python3-bleak-retry-connector (>= 3.0.0) \
    python3-bluetooth-data-tools (>= 1.28.0) \
    python3-crypt \
    python3-habluetooth (>= 3.42.0) \
    python3-logging \
    python3-netclient \
    python3-orjson (>= 3.11.6) \
    python3-yarl \
    python3-zeroconf (>= 0.148.0) \
"
