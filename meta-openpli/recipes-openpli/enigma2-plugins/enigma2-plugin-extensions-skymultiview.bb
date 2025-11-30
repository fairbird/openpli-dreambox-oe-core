DESCRIPTION = "SkyMultiview for E2"
require conf/license/license-gplv2.inc

inherit gittag

S = "${UNPACKDIR}/${BP}/src"

PV = "git"
PKGV = "${GITPKGVTAG}"

inherit setuptools3-openplugins python3-compileall

SRC_URI = "git://github.com/oe-alliance/SkyMultiview.git;protocol=https;branch=main"
