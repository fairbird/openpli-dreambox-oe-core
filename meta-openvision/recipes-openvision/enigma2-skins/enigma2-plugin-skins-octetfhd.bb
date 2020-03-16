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
		file://0001-Revert-Get-rid-of-skin-fonts.patch \
		file://FHDBold.ttf \
		file://OpenSans-Regular.ttf \
		file://XHD.ttf \
"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr"

do_package_qa[noexec] = "1"

do_install_prepend() {
	install -d ${B}${datadir}/enigma2/OctEtFHD/fonts
	cp -f ${WORKDIR}/FHDBold.ttf ${B}${datadir}/enigma2/OctEtFHD/fonts/FHDBold.ttf
	cp -f ${WORKDIR}/OpenSans-Regular.ttf ${B}${datadir}/enigma2/OctEtFHD/fonts/OpenSans-Regular.ttf
	cp -f ${WORKDIR}/XHD.ttf ${B}${datadir}/enigma2/OctEtFHD/fonts/XHD.ttf
}

do_install() {
    cp -r  --preserve=mode,links ${S}/usr ${D}/
}
