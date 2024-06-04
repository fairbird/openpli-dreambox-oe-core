DESCRIPTION = "Open Vision bootlogo"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "PLi team"
LICENSE = "CC-BY-NC-ND-4.0"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/meta-openpli/licenses/CC-BY-NC-ND-4.0;md5=8009795292660aa9c8da059e5b1581c1"

RDEPENDS:${PN} += "showiframe"

PV = "4.1"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

INITSCRIPT_NAME = "bootlogo"
INITSCRIPT_PARAMS = "start 21 S ."

inherit update-rc.d

SRC_URI = " \
	file://bootlogo.mvi \
	file://bootlogo.sh \
	file://logo-black-image.png \
	file://logo-black-square.png \
	file://logo-black.png \
	file://logo-white-image.png \
	file://logo-white-square.png \
	file://logo-white.png"

MVI = "bootlogo.mvi"
MVISYMLINKS = "bootlogo_wait backdrop"

PNG = "logo-black-image.png \
	logo-black-square.png \
	logo-black.png \
	logo-white-image.png \
	logo-white-square.png \
	logo-white.png"

do_install() {
	install -d ${D}/boot
	install -d ${D}${datadir}
	for i in ${MVI}; do
		install ${S}/$i ${D}${datadir}
		ln -sf ${datadir}/$i ${D}/boot/$i
	done
	for i in ${MVISYMLINKS}; do
		ln -sf /boot/bootlogo.mvi ${D}/boot/$i.mvi
		ln -sf ${datadir}/bootlogo.mvi ${D}${datadir}/$i.mvi;
	done
	install -d ${D}${datadir}/logo
	for i in ${PNG}; do
		install ${S}/$i ${D}${datadir}/logo
	done
	install -d ${D}/${sysconfdir}/init.d
	install -m 0755 ${S}/bootlogo.sh ${D}/${sysconfdir}/init.d/bootlogo
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES:${PN} = "/boot ${datadir} ${sysconfdir}/init.d"
