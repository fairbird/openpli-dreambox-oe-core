SUMMARY = "Hardware drivers for Dreambox"
SECTION = "base"
LICENSE = "CLOSED"
DEPENDS += "virtual/kernel"
PRIORITY = "required"
PR = "r7.0"

COMPATIBLE_MACHINE = "dm8000"

DREAMBOX_DVB_MODULES_MIRROR ?= "http://sources.dreamboxupdate.com/download/opendreambox/2.0.0/dreambox-dvb-modules"

SRC_URI = " \
			${DREAMBOX_DVB_MODULES_MIRROR}/dreambox-dvb-modules-${MACHINE}-${DM_LOCALVERSION}-${DRIVERDATE}.tar.bz2;name=modules \
			file://modules \
"

SRC_URI[modules.md5sum] = "ed55fd9ef298cd582e1f08322c8d9649"
SRC_URI[modules.sha256sum] = "3a11801794c7ac7cf04be41c65591bb2e81f4c6b08c1f33c86d17154f08f16be"

inherit module-base

do_compile() {
}

do_install() {
	install -d ${D}${sysconfdir}/modules-load.d
	install -m 0644 ${WORKDIR}/modules ${D}${sysconfdir}/modules-load.d/${PN}.conf
	install -d ${D}/lib/modules/${DM_LOCALVERSION}/extra
	install -m 0644 ${WORKDIR}/LICENSE ${D}/lib/modules/${DM_LOCALVERSION}/extra
	install -m 0644 ${WORKDIR}/*.ko ${D}/lib/modules/${DM_LOCALVERSION}/extra
}

PACKAGES = "${PN}"

RDEPENDS_${PN} += "dreambox-secondstage-${MACHINE} kernel-${DM_LOCALVERSION}"

# We don't use KERNEL_VERSION in this recipe, because the
# precompiled modules depend on a specific version.
DM_LOCALVERSION = "${@'-'.join('${PV}'.split('-')[:-1])}-${MACHINE}"
DRIVERDATE = "${@'${PV}'.split('-')[-1]}"

FILESEXTRAPATHS_prepend := "${THISDIR}/dreambox-dvb-modules:"

FILES_${PN} += "${sysconfdir}/modules-load.d/${PN}.conf /lib/modules/${DM_LOCALVERSION}/extra"
