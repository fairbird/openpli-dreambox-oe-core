DESCRIPTION = "Watch on demand TV."
require conf/license/license-gplv2.inc

RDEPENDS:${PN} = "python3-dnspython python3-beautifulsoup4 python3-lxml python3-simplejson python3-pyamf"

inherit gittag python3-compileall

S = "${UNPACKDIR}/${BP}/src"

SRCREV = "${AUTOREV}"
PV = "git"
PKGV = "V${GITPKGVTAG}"

inherit setuptools3-openplugins

SRC_URI = "git://github.com/oe-alliance-plugins/OnDemand.git;protocol=https;branch=main"
