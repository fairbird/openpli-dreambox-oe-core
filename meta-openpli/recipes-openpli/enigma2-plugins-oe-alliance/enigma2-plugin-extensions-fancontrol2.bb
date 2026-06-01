DESCRIPTION = "FanControl2"
require conf/license/license-gplv2.inc

RDEPENDS:${PN} = "hdparm smartmontools"

inherit gittag python3-compileall

S = "${UNPACKDIR}/${BP}/src"

SRCREV = "${AUTOREV}"
PV = "git"
PKGV = "V${GITPKGVTAG}"

inherit setuptools3-openplugins

SRC_URI = "git://github.com/oe-alliance-plugins/FanControl2.git;protocol=https;branch=main"
