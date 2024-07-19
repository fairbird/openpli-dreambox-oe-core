DESCRIPTION = "ArabicSavior plugin by (mfaraj57 & RAED) to fix arabic fonts and also to changing fonts type."
MAINTAINER = "RAED - fairbird"

require conf/license/license-gplv2.inc
require classes/python3-compileall.inc

SRC_URI = "git://github.com/fairbird/ArabicSavior;protocol=https;branch=main"

inherit gitpkgv setuptools3-openplugins

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"

PV = "1.1+git"
PKGV = "1.1+git${GITPKGV}"

FILES:${PN} = "${prefix}/"

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
	python3 -m compileall -o2 -b ${D}${prefix}
}

INSANE_SKIP:${PN} += "already-stripped"

do_package_qa[noexec] = "1"
