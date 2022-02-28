SUMMARY = "timezone.xml for enigma2"

require conf/license/openpli-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/openvision-xml.git;protocol=git"

FILES:${PN} = "/"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${sysconfdir}/tuxbox
	for i in timezone.xml; do
		install -m 0644 ${S}/xml/$i ${D}${sysconfdir}/tuxbox/$i
		ln -sf ${sysconfdir}/tuxbox/$i ${D}${sysconfdir}/;
	done;
}
