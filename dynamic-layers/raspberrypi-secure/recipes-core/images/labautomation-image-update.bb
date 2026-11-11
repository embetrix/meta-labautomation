SUMMARY = "SWUpdate bundle for the lab automation controller"
DESCRIPTION = "Secure Raspberry Pi boot and rootfs update for labautomation-image"

FILESEXTRAPATHS:prepend := "${RPI_SECURE_BASE}/dynamic-layers/swupdate/recipes-core/images/files:"

require recipes-core/images/rpi-secure-image-update.inc
