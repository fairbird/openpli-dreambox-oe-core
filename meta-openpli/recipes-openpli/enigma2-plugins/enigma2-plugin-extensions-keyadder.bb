DESCRIPTION = "Enigma2 plugin to add and edit keys for (Biss, PowerVU, Irdeto and Tandberg)."
MAINTAINER = "RAED - fairbird"

require conf/license/license-gplv2.inc

SRC_URI = "git://github.com/fairbird/KeyAdder;protocol=https;branch=main"

inherit gittag setuptools3-openplugins python3-compileall

RDEPENDS:${PN} += "\
	python3-six \
	"
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


