DESCRIPTION = "GriPLi FHD skin by Cino for Open Vision and OpenPLI based images."
MAINTAINER = "dreamosat-forum.com"
SECTION = "misc"
PRIORITY = "optional"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=858b014508205322d36421a11207867c"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

RRECOMMENDS_${PN} += "\
	enigma2-plugin-extensions-weatherplugin \
	enigma2-plugin-systemplugins-weathercomponenthandler \
	enigma2-plugin-skincomponents-weathercomponent \
	"

SRC_URI = "git://github.com/audi06/CinoGriPLi.git;protocol=git"

FILES_${PN} = "${prefix}"

S = "${WORKDIR}/git"

require skin-data.inc
require skin-python.inc
