SUMMARY = "Seven skin for Enigma2 (HD, FHD, UHD)"
MAINTAINER = "Team Kraven"
SECTION = "misc"
PRIORITY = "optional"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "python3-pillow", "python-imaging python-subprocess", d)} ${PYTHONNAMEONLY}-requests ${PYTHONNAMEONLY}-lxml enigma2-plugin-systemplugins-mphelp"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/KravenHD/SevenHD.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN} = "${prefix}/*"

require skin-python.inc

do_install() {
	cp -r --preserve=mode,links ${S}/data${prefix} ${D}/
}
