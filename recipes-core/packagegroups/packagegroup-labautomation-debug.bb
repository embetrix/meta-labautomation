SUMMARY = "Debugging and stress testing for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    gdb \
    gdbserver \
    strace \
    stress-ng \
"
