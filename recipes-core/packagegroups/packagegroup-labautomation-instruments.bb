SUMMARY = "Test and measurement instruments"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    python3-pyvisa \
    python3-pyvisa-py \
"
