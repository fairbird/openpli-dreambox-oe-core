SUMMARY = "tuxbox tuxtxt for 32bit framebuffer"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"
DEPENDS = "freetype libtuxtxt"
DESCRIPTION = "tuxbox tuxtxt for enigma2"

inherit autotools gitpkgv pkgconfig python3native

GITHUB_URI ?= "git://github.com"
SRC_URI = "${GITHUB_URI}/OpenPLi/tuxtxt.git;protocol=https;branch=master"

S = "${WORKDIR}/git/tuxtxt"

PV = "2.0+git"
PKGV = "2.0+git${GITPKGV}"
PR = "r3"

PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"
FILES:${PN} = "${libdir}/libtuxtxt32bpp.so.* ${datadir}/fonts ${libdir}/enigma2/python/Plugins/Extensions/Tuxtxt/* ${sysconfdir}/tuxtxt"
CONFFILES:${PN} = "${sysconfdir}/tuxtxt/tuxtxt2.conf"

EXTRA_OECONF = "--with-boxtype=generic --with-configdir=/etc \
	DVB_API_VERSION=5\
	"

PACKAGE_ARCH = "${MACHINE_ARCH}"
