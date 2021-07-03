SUMMARY = "Enigma2 Skin TurquoiseHD"
MAINTAINER = "norhap"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

RDEPENDS_${PN} = "enigma2-plugin-fonts-conceptotitulrough enigma2-plugin-fonts-lcd enigma2-plugin-fonts-nmsbd2 enigma2-plugin-fonts-verdana"

SRC_URI = "git://github.com/OpenVisionE2/TurquoiseHD-skin.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN} = "${prefix}"

do_package_qa[noexec] = "1"

require skin-data.inc
require skin-python.inc
