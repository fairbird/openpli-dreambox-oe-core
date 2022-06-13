LICENSE = "CLOSED"

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI[md5sum] = "66e88a2e3ea534c8bf22017d4179ec72"
SRC_URI = "https://gitlab.openpli.org/Andre/hanssettings.git"

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "xz"

inherit gitpkgv allarch

FILES:${PN} = "/etc/enigma2/"

do_install () {
	install -d ${D}/etc/enigma2
	cp -r ${S}/${SETTINGS_FILENAME}/* ${D}/etc/enigma2
}
