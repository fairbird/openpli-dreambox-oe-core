SUMMARY = "E2i Player for E2"
DESCRIPTION = "E2i Player for E2"
HOMEPAGE = "http://www.iptvplayer.gitlab.io/"
SECTION = "multimedia"
LICENSE = "GPLv2"
require conf/license/license-gplv2.inc

inherit allarch distutils-openplugins gitpkgv setuptools3

DEPENDS = "${PYTHON_PN}-future-native"

SRC_URI = "git://github.com/oe-mirrors/e2iplayer.git;branch=python3;protocol=https \
	file://no-need-to-check-depends.patch \
"

S = "${WORKDIR}/git"

PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"

RDEPENDS:${PN} = " \
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
	python3-core \
	python3-e2icjson \
	python3-pycurl \
	rtmpdump \
	uchardet \
	wget \
	"

RDEPENDS:{PN}-src = "${PN}"

FILES:${PN}-src = " \
	${libdir}/enigma2/python/Plugins/*-py3.10.egg-info/* \
        ${libdir}/enigma2/python/Plugins/*-py2.7.egg-info/* \
        ${libdir}/enigma2/python/Plugins/*/locale/*/LC_MESSAGES/*.po \
        "

deltask package_qa

FILES:${PN} += "${sysconfdir}"
