DESCRIPTION = "Enigma2 plugin to add and edit keys for (Biss, PowerVU, Irdeto and Tandberg)."
MAINTAINER = "RAED - fairbird"

require conf/license/license-gplv2.inc
require classes/python3-compileall.inc

SRC_URI = "git://github.com/fairbird/KeyAdder;protocol=https;branch=main"

inherit gitpkgv setuptools3-openplugins

RDEPENDS:${PN} += "\
	python3-six \
	"

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


