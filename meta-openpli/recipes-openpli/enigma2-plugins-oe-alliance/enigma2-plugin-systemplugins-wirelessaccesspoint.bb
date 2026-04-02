DESCRIPTION = "Using a Wireless module as AP."
require conf/license/license-gplv2.inc

inherit python3-compileall

RDEPENDS:${PN} = "hostapd bridge-utils"

inherit gittag

S = "${UNPACKDIR}/${BP}/src"

SRCREV = "${AUTOREV}"
PV = "git"
PKGV = "V${GITPKGVTAG}"

inherit setuptools3-openplugins

SRC_URI = "git://github.com/oe-alliance-plugins/WirelessAccessPoint.git;protocol=https;branch=main"
