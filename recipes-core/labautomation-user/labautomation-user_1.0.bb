SUMMARY = "Lab automation user and device access permissions"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://99-labautomation.rules \
    file://labautomation-usb-hub-permissions \
"
S = "${UNPACKDIR}"

inherit useradd

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = " \
    --system plugdev; \
    --system usb; \
    --system dialout; \
    --system disk; \
    --system gpio; \
    --system i2c; \
    --system spi; \
    --system docker; \
    --system kvm \
"

# A regular login account with a locked password until provisioned by an admin.
USERADD_PARAM:${PN} = "--create-home --user-group --key HOME_MODE=0750 \
    --home-dir /home/labautomation --shell /bin/sh --password '!' \
    --groups plugdev,usb,dialout,disk,gpio,i2c,spi,docker,kvm labautomation"

RDEPENDS:${PN} = "udev"

do_install() {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${UNPACKDIR}/99-labautomation.rules ${D}${sysconfdir}/udev/rules.d/
    sed -i 's|@LIBEXECDIR@|${libexecdir}|g' ${D}${sysconfdir}/udev/rules.d/99-labautomation.rules

    install -d ${D}${libexecdir}
    install -m 0755 ${UNPACKDIR}/labautomation-usb-hub-permissions ${D}${libexecdir}/

    install -d -m 0750 ${D}/home/labautomation
    install -d -m 0700 ${D}/home/labautomation/.ssh
    chown -R labautomation:labautomation ${D}/home/labautomation
}

FILES:${PN} += "/home/labautomation"
