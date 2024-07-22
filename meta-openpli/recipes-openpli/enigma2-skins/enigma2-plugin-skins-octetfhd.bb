SUMMARY = "Enigma2 Skin OctEtFHD"
MAINTAINER = "Open Vision Developers"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

inherit gitpkgv allarch

PV = "git"
PKGV = "git${GITPKGV}"

RRECOMMENDS:${PN} = "enigma2-plugin-extensions-weatherplugin"

SRC_URI="git://github.com/OpenVisionE2/OctEtFHD-skin.git;protocol=git;protocol=https;branch=master \
		file://OpenSans-Bold.ttf \
		file://OpenSans-Regular.ttf \
		file://segoe-ui-bold.ttf \
"

S = "${WORKDIR}/git"

FILES:${PN} = "/usr"



do_install:prepend() {
	install -d ${B}${datadir}/fonts
	cp -f ${UNPACKDIR}/OpenSans-Bold.ttf ${B}${datadir}/fonts/OpenSans-Bold.ttf
	cp -f ${UNPACKDIR}/OpenSans-Regular.ttf ${B}${datadir}/fonts/OpenSans-Regular.ttf
	cp -f ${UNPACKDIR}/segoe-ui-bold.ttf ${B}${datadir}/fonts/segoe-ui-bold.ttf
}

do_install() {
    cp -r  --preserve=mode,links ${S}/usr ${D}/
}
