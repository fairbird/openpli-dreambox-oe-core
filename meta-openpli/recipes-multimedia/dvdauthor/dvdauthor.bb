SUMMARY = "create DVD-Video file system"
SECTION = "console/multimedia"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
DEPENDS = "bison-native fontconfig freetype libdvdread fribidi libpng libxml2 zlib"

SRC_URI = "git://github.com/ldo/dvdauthor;protocol=https;branch=master file://fix-build.patch"

inherit gitpkgv
PV = "0.7.1+git"
PKGV = "0.7.1+git${GITPKGV}"

S = "${WORKDIR}/git"

do_configure:prepend() {
	mkdir -p ${S}/autotools
	cp ${STAGING_DATADIR_NATIVE}/gettext/config.rpath ${S}/autotools/
}

inherit autotools gettext pkgconfig

EXTRA_OECONF = " \
		ac_cv_prog_MAGICKCONFIG= \
		ac_cv_prog_GMAGICKCONFIG= \
"

