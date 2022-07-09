SUMMARY = "E2iPlayer"
DESCRIPTION = "Watch Videos Online"
HOMEPAGE = "https://gitlab.com/iptvplayer-for-e2/"
SECTION = "multimedia"
LICENSE = "GPLv2"
require conf/license/license-gplv2.inc

SRC_URI = "git://github.com/oe-mirrors/e2iplayer.git;protocol=http;branch=master \
	file://no-need-to-check-depends.patch \
"

S = "${WORKDIR}/git"

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r0"

inherit ${@bb.utils.contains("python", "python", "distutils-openplugins", "distutils-openplugins", d)} gettext

DEPENDS = "gettext-native python-future-native python"

RDEPENDS_${PN} = " \
	python-core \
	python-e2icjson \
	python-json \
	python-pycurl \
	python-html \
	python-shell \
	python-compression \
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
	rtmpdump \
	uchardet \
	wget \
	${@bb.utils.contains("python", "python", "python-subprocess", "", d)} \
        ${@bb.utils.contains("python", "python", "python-textutils", "", d)} \
	"

RDEPENDS_{PN}-src = "${PN}"
FILES_${PN}-src = " \
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
