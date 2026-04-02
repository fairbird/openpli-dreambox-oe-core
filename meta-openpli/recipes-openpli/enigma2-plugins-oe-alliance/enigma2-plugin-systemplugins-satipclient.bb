DESCRIPTION = "Satip Client setup"
require conf/license/license-gplv2.inc

RDEPENDS:${PN} = "satipclient"
DEPENDS = "satipclient"
REPLACES:${PN} = "enigma2-plugin-extensions-satipclient"

inherit gittag python3-compileall

S = "${UNPACKDIR}/${BP}/src"

SRCREV = "${AUTOREV}"
PV = "git"
PKGV = "V${GITPKGVTAG}"

inherit setuptools3-openplugins

SRC_URI = "git://github.com/oe-alliance-plugins/SatipClient.git;protocol=https;branch=main"
