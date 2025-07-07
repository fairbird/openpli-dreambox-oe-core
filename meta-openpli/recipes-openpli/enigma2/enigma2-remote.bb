DESCRIPTION = "OE-Alliance remote control and box image files for Enimga2 and OpenWebIF."
MAINTAINER = "OE-Alliance"
require conf/license/license-gplv2.inc

inherit gitpkgv

PV = "git"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/oe-alliance/remotes;protocol=https;branch=master"

FILES:${PN} = "/"
do_install() {
	install -d ${D}${datadir}/enigma2/
	install -d ${D}${datadir}/enigma2/rc_models
	ln -s rc_models ${D}${datadir}/enigma2/hardware

	install -m 0644 ${S}/remotes.xml ${D}${datadir}/enigma2/remotes.xml

	if [ ${RCNAME} != "N/A" ] ; then
		install -m 0644 ${S}/png/${RCNAME}.png ${D}${datadir}/enigma2/rc_models/
		install -m 0644 ${S}/xml/${RCNAME}.xml ${D}${datadir}/enigma2/rc_models/
		install -m 0644 ${S}/html/${RCNAME}.html ${D}${datadir}/enigma2/rc_models/
	fi

	install -m 0644 ${S}/png/dmm1.png ${D}${datadir}/enigma2/rc_models/
	install -m 0644 ${S}/xml/dmm1.xml ${D}${datadir}/enigma2/rc_models/
	install -m 0644 ${S}/html/dmm1.html ${D}${datadir}/enigma2/rc_models/
	if [ ${MACHINEBUILD} = "dm520" ]; then
		install -m 0644 ${S}/boxes/dm520.png ${D}${datadir}/enigma2/hardware/dm520_front.png
		install -m 0644 ${S}/boxes/dm525.png ${D}${datadir}/enigma2/hardware/dm525_front.png
	elif [ ${MACHINEBUILD} = "dm900" ]; then
		install -m 0644 ${S}/boxes/dm900.png ${D}${datadir}/enigma2/hardware/dm900_front.png
		install -m 0644 ${S}/boxes/dm920.png ${D}${datadir}/enigma2/hardware/dm920_front.png
	else
		install -m 0644 ${S}/boxes/${MACHINEBUILD}.png ${D}${datadir}/enigma2/hardware/${MACHINEBUILD}_front.png
	fi
}

FILES:${PN} = "${datadir}/enigma2 ${datadir}/enigma2/rc ${datadir}/enigma2/hardware"

INSANE_SKIP:${PN} += "already-stripped"
