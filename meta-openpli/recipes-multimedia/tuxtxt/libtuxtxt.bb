SUMMARY = "tuxbox libtuxtxt"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"
DEPENDS = "libpng freetype zlib"

inherit gitpkgv

GITHUB_URI ?= "git://github.com"
SRC_URI = " ${GITHUB_URI}/OpenPLi/tuxtxt.git;protocol=https;branch=master \
			file://0001-fix-secfault-w-use-wrong-line_length.patch \
			"

S = "${WORKDIR}/git/libtuxtxt"

PV = "2.0+git${SRCPV}"
PKGV = "2.0+git${GITPKGV}"

EXTRA_OECONF = "--with-boxtype=generic DVB_API_VERSION=5"

inherit autotools pkgconfig
