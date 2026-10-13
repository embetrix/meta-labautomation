SUMMARY = "Development and debugging tools for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    gdb \
    gdbserver \
    strace \
    stress-ng \
"
