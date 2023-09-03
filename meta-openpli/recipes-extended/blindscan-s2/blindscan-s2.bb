DESCRIPTION = "Blindscan dvb-s(2) satellites using stv090x devices"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://README.md;md5=b69b6d0feee577047e07a832c67d8076"

SRC_URI = "git://github.com/OpenVisionE2/blindscan-s2.git;protocol=https;branch=master"

inherit gitpkgv
PV = "1+git"
PKGV = "1+git${GITPKGV}"

S = "${WORKDIR}/git"

do_install () {
	install -d ${D}/${bindir}
	install -m 755 ${S}/blindscan-s2 ${D}/${bindir}
}
