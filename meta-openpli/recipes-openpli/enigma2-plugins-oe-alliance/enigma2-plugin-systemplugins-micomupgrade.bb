DESCRIPTION = "micomupgrade"
require conf/license/license-gplv2.inc

inherit gittag python3-compileall

S = "${UNPACKDIR}/${BP}/src"

SRCREV = "${AUTOREV}"
PV = "git"
PKGV = "V${GITPKGVTAG}"

inherit setuptools3-openplugins

SRC_URI = "git://github.com/oe-alliance-plugins/MICOMUpgrade.git;protocol=https;branch=main"


do_install:append() {
    install -d ${D}/usr/lib/enigma2/python/Plugins/SystemPlugins/MICOMUpgrade/bin
    install -m 0755 ${S}/MICOMUpgrade/bin/fbclear ${D}/usr/lib/enigma2/python/Plugins/SystemPlugins/MICOMUpgrade/bin/fbclear
}

FILES:${PN} += "/usr/lib/enigma2/python/Plugins/SystemPlugins/MICOMUpgrade/bin/fbclear"

INSANE_SKIP = "32bit-time"
