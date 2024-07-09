FILESEXTRAPATHS:prepend := "${THISDIR}/gcc:"

SRC_URI:append = " file://0001-Arm-Fix-ldrd-offset-range-PR115153.patch"
