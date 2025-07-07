SUMMARY = "biTStream is a set of C headers"
DESCRIPTION = "biTStream is a set of C headers allowing a simpler access to binary \
	structures such as specified by MPEG, DVB, IETF, SMPTE, IEEE, SCTE, etc."
SECTION = "multimedia"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=7decd8ef15ab16ed5436851272b61cf7"

inherit gitpkgv

PV = "1.4+git"
PKGV = "1.4+git${GITPKGV}"

SRC_URI = "git://github.com/videolan/bitstream.git;protocol=https;branch=master"
S = "${UNPACKDIR}/git"

inherit pkgconfig

do_configure() {
}

do_compile:prepend() {
	sed -i 's#/usr/local#/usr#' ${S}/Makefile
}

do_install:append() {
	cd ${S}
	oe_runmake 'DESTDIR=${D}' install
	install -d ${D}${includedir}
}
