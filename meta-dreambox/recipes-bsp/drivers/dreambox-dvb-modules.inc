SUMMARY = "Hardware drivers for Dreambox"
SECTION = "base"
LICENSE = "CLOSED"
DEPENDS += "virtual/kernel"
PRIORITY = "required"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DREAMBOX_DVB_MODULES_MIRROR ?= "http://sources.dreamboxupdate.com/download/opendreambox/2.0.0/dreambox-dvb-modules"

SRC_URI = " \
	${DREAMBOX_DVB_MODULES_MIRROR}/dreambox-dvb-modules-${MACHINE}-3.2-${MACHINE}-${DRIVERDATE}.tar.bz2;name=modules \
	file://modules \
	"

inherit module-base

do_compile() {
}

do_install() {
	install -d ${D}${sysconfdir}/modules-load.d
	install -m 0644 ${WORKDIR}/modules ${D}${sysconfdir}/modules-load.d/${PN}.conf
	install -d ${D}${nonarch_base_libdir}/modules/${DM_LOCALVERSION}/extra
	install -m 0644 ${WORKDIR}/LICENSE ${D}${nonarch_base_libdir}/modules/${DM_LOCALVERSION}/extra
	install -m 0644 ${WORKDIR}/*.ko ${D}${nonarch_base_libdir}/modules/${DM_LOCALVERSION}/extra
}

PACKAGES = "${PN}"

RDEPENDS_${PN} += "dreambox-secondstage-${MACHINE} kernel-${DM_LOCALVERSION}"

# We don't use KERNEL_VERSION in this recipe, because the
# precompiled modules depend on a specific version.
DM_LOCALVERSION = "${@'-'.join('${PV}'.split('-')[:-1])}-${MACHINE}"
DRIVERDATE = "${@'${PV}'.split('-')[-1]}"

FILESEXTRAPATHS_prepend := "${THISDIR}/dreambox-dvb-modules:"

FILES_${PN} += "${sysconfdir}/modules-load.d/${PN}.conf ${nonarch_base_libdir}/modules/${DM_LOCALVERSION}/extra"
