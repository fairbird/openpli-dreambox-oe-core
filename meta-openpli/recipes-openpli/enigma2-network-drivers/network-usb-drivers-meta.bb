SUMMARY = "meta file for USB Network drivers"
PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup

require conf/license/license-gplv2.inc

PR = "r2"

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
	${OPTIONAL_WIFI_PACKAGES} \
"

OPTIONAL_WIFI_PACKAGES = "\
    ${@ 'enigma2-plugin-drivers-network-usb-rtl88xxau'     if bb.utils.vercmp_string_op('${PREFERRED_VERSION_${PREFERRED_PROVIDER_virtual/kernel}}', '4.4', '>=') else '' } \
    ${@ 'enigma2-plugin-drivers-network-usb-rtl8852cu'     if bb.utils.vercmp_string_op('${PREFERRED_VERSION_${PREFERRED_PROVIDER_virtual/kernel}}', '3.10', '>=') else '' } \
    ${@ 'enigma2-plugin-drivers-network-usb-rtl8852bu'     if bb.utils.vercmp_string_op('${PREFERRED_VERSION_${PREFERRED_PROVIDER_virtual/kernel}}', '3.10', '>=') else '' } \
"

INSANE_SKIP:${PN} += "build-deps"
