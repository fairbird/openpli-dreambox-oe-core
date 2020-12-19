SUMMARY = "Enigma2 Skin iFlatFHD"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

RDEPENDS_${PN} = "enigma2-plugin-extensions-weatherplugin2 enigma2-plugin-extensions-openvisionskintools"

SRC_URI = "git://github.com/OpenVisionE2/iFlatFHD-skin.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN} = "${prefix}"

do_package_qa[noexec] = "1"

require skin-data.inc
require skin-python.inc
