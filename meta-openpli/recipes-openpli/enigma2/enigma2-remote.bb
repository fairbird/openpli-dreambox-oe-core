DESCRIPTION = "OE-Alliance remote control and box image files for Enimga2 and OpenWebIF."
MAINTAINER = "OE-Alliance"
require conf/license/license-gplv2.inc

inherit gitpkgv

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/oe-alliance/remotes;protocol=https;branch=master"

FILES:${PN} = "/"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/enigma2/
	install -d ${D}${datadir}/enigma2/rc_models

	install -m 0644 ${S}/remotes.xml ${D}${datadir}/enigma2/remotes.xml

	if [ ${RCNAME} != "N/A" ] ; then
		install -m 0644 ${S}/png/${RCNAME}.png ${D}${datadir}/enigma2/rc_models/
		install -m 0644 ${S}/xml/${RCNAME}.xml ${D}${datadir}/enigma2/rc_models/
		install -m 0644 ${S}/html/${RCNAME}.html ${D}${datadir}/enigma2/rc_models/
	fi

	install -m 0644 ${S}/png/dmm1.png ${D}${datadir}/enigma2/rc_models/
	install -m 0644 ${S}/xml/dmm1.xml ${D}${datadir}/enigma2/rc_models/
	install -m 0644 ${S}/html/dmm1.html ${D}${datadir}/enigma2/rc_models/
}

FILES:${PN} = "${datadir}/enigma2 ${datadir}/enigma2/rc"

INSANE_SKIP:${PN} += "already-stripped"
