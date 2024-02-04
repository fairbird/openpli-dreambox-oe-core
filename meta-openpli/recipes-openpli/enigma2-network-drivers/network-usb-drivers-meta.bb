SUMMARY = "meta file for USB Network drivers"
inherit packagegroup
PACKAGE_ARCH = "${MACHINE_ARCH}"
require conf/license/license-gplv2.inc

ALLOW_EMPTY:${PN} = "1"
PACKAGES = "${PN}"

PV = "1.0"

RDEPENDS:${PN} = "\
	enigma2-plugin-drivers-network-usb-rt2500 \
	enigma2-plugin-drivers-network-usb-rtl8187 \
	enigma2-plugin-drivers-network-usb-r8712u \
	enigma2-plugin-drivers-network-usb-rtl8812au \
	enigma2-plugin-drivers-network-usb-rtl8192cu-rev2 \
	enigma2-plugin-drivers-network-usb-carl9170 \
	enigma2-plugin-drivers-network-usb-rt2800 \
	enigma2-plugin-drivers-network-usb-r8188eu \
	enigma2-plugin-drivers-network-usb-rt73 \
	enigma2-plugin-drivers-network-usb-zd1211rw \
	enigma2-plugin-drivers-network-usb-mt7601u \
	enigma2-plugin-drivers-network-usb-rtl8152 \
	enigma2-plugin-drivers-network-usb-lan78xx \
"
