DESCRIPTION = "this is dlna/upnp browser using djmount"
require conf/license/license-gplv2.inc

inherit python3-compileall

RDEPENDS:${PN} = "djmount fuse-utils fuse libupnp neon"

inherit gittag

S = "${UNPACKDIR}/${BP}/src"

PV = "git"
PKGV = "V${GITPKGVTAG}"

inherit setuptools3-openplugins

SRC_URI = "git://github.com/oe-alliance-plugins/DLNABrowser.git;protocol=https;branch=main"
