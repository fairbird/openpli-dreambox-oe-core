SUMMARY = "Enigma2 Skin UniverseHD"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/UniverseHD-skin.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN} = "${prefix}"

do_package_qa[noexec] = "1"

require skin-data.inc
require skin-python.inc

CONFFILES_${PN} = " \
	${datadir}/enigma2/UniverseHD/construct/backgrounds/background-infobar.png \
	${datadir}/enigma2/UniverseHD/construct/backgrounds/background-symbol.png \
	${datadir}/enigma2/UniverseHD/construct/backgrounds/background-window.png \
	${datadir}/enigma2/UniverseHD/construct/backgrounds/background-window-details.png \
	${datadir}/enigma2/UniverseHD/construct/backgrounds/background-window-title.png \
	"
