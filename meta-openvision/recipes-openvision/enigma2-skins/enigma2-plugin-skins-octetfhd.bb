SUMMARY = "Enigma2 Skin OctEtFHD"
MAINTAINER = "Open Vision Developers"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

RRECOMMENDS_${PN} = "enigma2-plugin-extensions-weatherplugin2"

SRC_URI="git://github.com/OpenVisionE2/OctEtFHD-skin.git;protocol=git \	
		file://OpenSans-Bold.ttf \
		file://OpenSans-Regular.ttf \
		file://segoe-ui-bold.ttf \
"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr"

do_package_qa[noexec] = "1"

do_install_prepend() {
	install -d ${B}${datadir}/fonts
	cp -f ${WORKDIR}/OpenSans-Bold.ttf ${B}${datadir}/fonts/OpenSans-Bold.ttf
	cp -f ${WORKDIR}/OpenSans-Regular.ttf ${B}${datadir}/fonts/OpenSans-Regular.ttf
	cp -f ${WORKDIR}/segoe-ui-bold.ttf ${B}${datadir}/fonts/segoe-ui-bold.ttf
}

do_install() {
    cp -r  --preserve=mode,links ${S}/usr ${D}/
}
