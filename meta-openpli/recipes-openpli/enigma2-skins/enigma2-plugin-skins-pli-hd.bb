DESCRIPTION = "PLi HD skin"
MAINTAINER = "littlesat"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://usr/share/enigma2/PLi-HD/skin.xml;beginline=3;endline=8;md5=1d560d35b9194281a488eb3a32d9c8bf"

inherit gitpkgv allarch

PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"

SRC_URI = "git://github.com/Hains/skin-PLiHD.git;branch=python3;protocol=https \
	file://01-add-support-to-new-date-time-feature.patch;apply=yes \
	file://02-add-crontimers-screen.patch;apply=yes \
	file://03-add-NewHelp-screen.patch;apply=yes \
"

FILES:${PN} = "${datadir}/enigma2/"

S = "${WORKDIR}/git"

do_compile() {
}

do_install() {
	install -d ${D}${datadir}
	cp -r ${S}${datadir}/* ${D}${datadir}/
	chmod -R a+rX ${D}${datadir}/enigma2/
}
