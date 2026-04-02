DESCRIPTION = "Norwegian P4 FEM PAA radio show player."
require conf/license/license-gplv2.inc

inherit python3-compileall

inherit gittag

S = "${UNPACKDIR}/${BP}/src"

SRCREV = "${AUTOREV}"
PV = "git"
PKGV = "V${GITPKGVTAG}"

inherit setuptools3-openplugins

SRC_URI = "git://github.com/oe-alliance-plugins/Fempa.git;protocol=https;branch=main"
