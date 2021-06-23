SUMMARY = "Remote control for enigma2 and Openwebif"

require conf/license/openvision-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/ov-remotes.git;protocol=git"

FILES_${PN} = "/"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/enigma2/
	install -d ${D}${datadir}/enigma2/rc
	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes
	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes

	install -m 0644 ${S}/remotes.xml ${D}${datadir}/enigma2/remotes.xml
	install -m 0644 ${S}/png/${RCNAME}.png ${D}${datadir}/enigma2/rc/
	install -m 0644 ${S}/xml/${RCNAME}.xml ${D}${datadir}/enigma2/rc/
	install -m 0644 ${S}/png/dmm1.png ${D}${datadir}/enigma2/rc/
	install -m 0644 ${S}/xml/dmm1.xml ${D}${datadir}/enigma2/rc/
	install -m 0644 ${S}/boxes/dm920.png ${D}${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/images/boxes/dm920.png
	install -m 0644 ${S}/html/dmm2.html ${D}${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/dmm2.html
	install -m 0644 ${S}/html/dmm1.html ${D}${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/static/remotes/dmm1.html
}
