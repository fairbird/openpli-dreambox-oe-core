SUMMARY = "XION skin for HDF Images"
MAINTAINER = "Team Kraven"
SECTION = "misc"
PRIORITY = "optional"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "python-requests"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/KravenHD/XionHDF.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN} = "${prefix}"

require skin-data.inc
require skin-python.inc
