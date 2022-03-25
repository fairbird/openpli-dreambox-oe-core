SUMMARY = "Kraven VB skin for Enigma2"
MAINTAINER = "Team Kraven"
SECTION = "misc"
PRIORITY = "optional"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "python-imaging python-subprocess python-requests python-lxml enigma2-plugin-systemplugins-mphelp"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/KravenHD/KravenVB.git;protocol=https"

S = "${WORKDIR}/git"

FILES_${PN} = "${prefix}/* ${sysconfdir}/*"

require skin-data.inc
require skin-python.inc
