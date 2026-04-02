DESCRIPTION = "Setup multitranscoding"
require conf/license/license-gplv2.inc

inherit gittag python3-compileall

S = "${UNPACKDIR}/${BP}/src"

SRCREV = "${AUTOREV}"
PV = "git"
PKGV = "V${GITPKGVTAG}"

inherit setuptools3-openplugins

SRC_URI = "git://github.com/oe-alliance-plugins/MultiTransCodingSetup.git;protocol=https;branch=main"
