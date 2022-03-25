SUMMARY = "E2i Player for E2"
DESCRIPTION = "E2i Player for E2"
HOMEPAGE = "http://www.iptvplayer.gitlab.io/"
SECTION = "multimedia"
LICENSE = "GPLv2"
require conf/license/license-gplv2.inc

inherit allarch distutils-openplugins gitpkgv setuptools

DEPENDS = "python-future-native"

SRC_URI = "git://github.com/oe-mirrors/e2iplayer.git;branch=master;protocol=https"

S = "${WORKDIR}/git"

PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"

RDEPENDS_${PN} = " \
	cmdwrapper \
	duktape \
	exteplayer3 \
	f4mdump \
	ffmpeg \
	gst-ifdsrc \
	gstplayer \
	hlsdl \
	iptvsubparser \
	lsdir \
	python-core \
	python-e2icjson \
	python-pycurl \
	rtmpdump \
	uchardet \
	wget \
	"

RDEPENDS_{PN}-src = "${PN}"

FILES_${PN}-src = " \
	${libdir}/enigma2/python/Plugins/*-py3.10.egg-info/* \
	${libdir}/enigma2/python/Plugins/*/locale/*/LC_MESSAGES/*.po \
        ${libdir}/enigma2/python/Plugins/*/*.py \
        ${libdir}/enigma2/python/Plugins/*/*/*.py \
        ${libdir}/enigma2/python/Plugins/*/*/*/*.py \
        ${libdir}/enigma2/python/Plugins/*/*/*/*/*.py \
        ${libdir}/enigma2/python/Plugins/*/*/*/*/*/*.py \
        ${libdir}/enigma2/python/Plugins/*-py2.7.egg-info/* \
        ${libdir}/enigma2/python/Plugins/*/locale/*/LC_MESSAGES/*.po \
        "

deltask package_qa

FILES_${PN} += "${sysconfdir}"
