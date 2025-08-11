DESCRIPTION = "PlutoTV for E2"
require conf/license/license-gplv2.inc

RDEPENDS:${PN} = "enigma2-plugin-systemplugins-serviceapp"

inherit gittag setuptools3-openplugins python3-compileall

S = "${UNPACKDIR}/${BP}/src"

SRCREV = "${AUTOREV}"
PV = "git"
PKGV = "${GITPKGVTAG}"

SRC_URI = "git://github.com/oe-alliance/PlutoTV.git;protocol=https;branch=main"
