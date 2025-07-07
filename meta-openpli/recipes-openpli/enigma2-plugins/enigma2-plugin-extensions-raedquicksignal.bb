DESCRIPTION = "plugin to show information for channels such as (SNR, AGC, picon, encrypted channel info and also to download picons )."
MAINTAINER = "RAED - fairbird"

require conf/license/license-gplv2.inc

SRC_URI = "git://github.com/fairbird/RaedQuickSignal;protocol=https;branch=main"

inherit gitpkgv setuptools3-openplugins python3-compileall

RDEPENDS:${PN} += "\
	python3-requests \
	python3-six \
	"
SRCREV = "${AUTOREV}"

PV = "17.6+git"
PKGV = "17.6+git${GITPKGV}"

FILES:${PN} = "${prefix}/"

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/RaedQuickSignal/PICONS
	cp -r ${S}/tmp/RaedQuickSignal/* ${D}/usr/lib/enigma2/python/Plugins/Extensions/RaedQuickSignal/PICONS
	python3 -m compileall -o2 -b ${D}${prefix} -d /
}

INSANE_SKIP:${PN} += "already-stripped"


