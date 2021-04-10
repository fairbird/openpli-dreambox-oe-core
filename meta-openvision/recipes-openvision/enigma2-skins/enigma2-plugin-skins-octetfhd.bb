SUMMARY = "Enigma2 Skin OctEtFHD"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

RDEPENDS_${PN} += "\
	enigma2-plugin-extensions-weatherplugin \
	${@bb.utils.contains_any("MACHINE_FEATURES", "smallflash middleflash", "", "enigma2-plugin-extensions-xtraevent", d)} \
	enigma2-plugin-fonts-opensans \
	enigma2-plugin-fonts-segoe \
	enigma2-plugin-skincomponents-weathercomponent \
	enigma2-plugin-systemplugins-weathercomponenthandler \
	"

SRC_URI = "git://github.com/OpenVisionE2/OctEtFHD-skin.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN} = "${prefix}"

do_package_qa[noexec] = "1"

require skin-data.inc
