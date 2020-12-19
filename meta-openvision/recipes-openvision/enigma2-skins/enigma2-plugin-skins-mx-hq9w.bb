SUMMARY = "Enigma2 Skin MX HQ9W"
MAINTAINER = "OBH"
SECTION = "misc"
PRIORITY = "optional"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "enigma2-plugin-fonts-tiny"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI= " \
	git://github.com/BlackHole/MX_HQ9W.git;protocol=git \
	file://rc.patch;patch=1 \
	"

S = "${WORKDIR}/git"

FILES_${PN} = "${prefix}/*"

do_compile() {
}

do_install() {
	rm -Rf ${S}${prefix}/uninstall
	rm -Rf ${S}${datadir}/fonts
	cp -r --preserve=mode,links ${S}${prefix} ${D}/
}
