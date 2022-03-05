SUMMARY = "Remote control for enigma2"

require conf/license/openpli-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/ov-remotes.git;protocol=https;branch=master"

FILES_${PN} = "/"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/enigma2/
	install -d ${D}${datadir}/enigma2/rc_models

	install -m 0644 ${S}/remotes.xml ${D}${datadir}/enigma2/remotes.xml

	install -m 0644 ${S}/png/${RCNAME}.png ${D}${datadir}/enigma2/rc_models/
	install -m 0644 ${S}/xml/${RCNAME}.xml ${D}${datadir}/enigma2/rc_models/
	install -m 0644 ${S}/html/${RCNAME}.html ${D}${datadir}/enigma2/rc_models/

	install -m 0644 ${S}/png/dmm1.png ${D}${datadir}/enigma2/rc_models/
	install -m 0644 ${S}/xml/dmm1.xml ${D}${datadir}/enigma2/rc_models/
	install -m 0644 ${S}/html/dmm1.html ${D}${datadir}/enigma2/rc_models/
}

INSANE_SKIP:${PN} += "already-stripped"
