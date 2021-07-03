SUMMARY = "Enigma2 Skin ${SKINNAME} by RAED (fairbird) for Open Vision"
DESCRIPTION = "Modified enigma2 skin for Open Vision by RAED"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

require skin-data.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

RDEPENDS_${PN} += "\
	enigma2-plugin-extensions-weatherplugin \
	enigma2-plugin-extensions-openvisionskintools \
	enigma2-plugin-systemplugins-weathercomponenthandler \
	enigma2-plugin-skincomponents-weathercomponent \
	"

SRC_URI = "git://github.com/OpenVisionE2/RAED-Mod-Skins.git;protocol=git"

S = "${WORKDIR}/git/${SKINNAME}"

do_package_qa[noexec] = "1"

FILES_${PN} = "${prefix}"
