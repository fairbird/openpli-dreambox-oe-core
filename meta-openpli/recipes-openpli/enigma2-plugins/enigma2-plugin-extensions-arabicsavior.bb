DESCRIPTION = "ArabicSavior plugin by (mfaraj57 & RAED) to fix arabic fonts and also to changing fonts type."
MAINTAINER = "RAED - fairbird"

require conf/license/license-gplv2.inc

SRC_URI = "git://github.com/fairbird/ArabicSavior;protocol=https;branch=main"

inherit gittag setuptools3-openplugins python3-compileall
SRCREV = "${AUTOREV}"

PV = "git"
PKGV = "${GITPKGVTAG}"

FILES:${PN} = "${prefix}/"

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
	python3 -m compileall -o2 -b ${D}${prefix} -d /
}

INSANE_SKIP:${PN} += "already-stripped"
