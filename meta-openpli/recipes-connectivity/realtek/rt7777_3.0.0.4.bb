DESCRIPTION = "Driver for Ralink rt7777 USB 802.11a/b/g/n/ac WiFi sticks"
HOMEPAGE = "www.mediatek.com"
SECTION = "kernel/modules"
LICENSE = "GPL-2.0-only"
require conf/license/license-gplv2.inc

inherit module

SRC_URI = " \
	https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/MT7601.zip \
	file://fwpath.patch \
	file://rt2870-mt7601Usta-kuid_t-kgid_t.patch \
	file://remove_linux_2_4_compability.patch \
	"

SRC_URI[md5sum] = "dfd849b989fc55bdb7908dd5f51945f9"
SRC_URI[sha256sum] = "883a72561db243c7c4337031658ee588b087682099aeab8012fb6006cf57d1b5"

S = "${WORKDIR}/DPO_MT7601U_LinuxSTA_3.0.0.4_20130913"

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR}"

#EXTRA_OEMAKE = "KSRC=${STAGING_KERNEL_DIR}"

FILES:${PN} += " \
	${sysconfdir}/Wireless \
	/lib/firmware/ \
"

do_install() {
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -m 0644 ${S}/os/linux/mt7601Usta.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/rt7777.ko
    install -d ${D}${sysconfdir}/Wireless/RT7777
    install -m 0644 ${S}/RT2870STA.dat ${D}${sysconfdir}/Wireless/RT7777
}
