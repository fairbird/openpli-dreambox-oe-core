DESCRIPTION = "xtraEvent plugin by digiteng to show extra events for enigma2 skins."
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/fairbird/xtraEvent;protocol=https;branch=main"

inherit gitpkgv distutils-openplugins

RDEPENDS:${PN} += "\
	python-image \
	python-imaging \
	python-requests \
	"

S = "${WORKDIR}/git"

PV = "5.2+git${SRCPV}"
PKGV = "5.2+git${GITPKGV}"

FILES:${PN} = "${prefix}/"

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
}
