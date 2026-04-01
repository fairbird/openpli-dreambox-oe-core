DESCRIPTION = "iptv player"
require conf/license/license-gplv2.inc

RDEPENDS:${PN} = "rtmpdump"

inherit gittag python3-compileall

S = "${UNPACKDIR}/${BP}/src"

SRCREV = "${AUTOREV}"
PV = "git"
PKGV = "V${GITPKGVTAG}"

inherit setuptools3-openplugins

SRC_URI = "git://github.com/oe-alliance-plugins/StreamTV.git;protocol=https;branch=main"
