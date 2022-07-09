SUMMARY = "E2iPlayer"
DESCRIPTION = "Watch Videos Online"
HOMEPAGE = "https://gitlab.com/iptvplayer-for-e2/"
SECTION = "multimedia"
LICENSE = "GPL-2.0-only"
require conf/license/license-gplv2.inc

inherit ${@bb.utils.contains("python3", "python3", "distutils-openplugins", "distutils-openplugins", d)} gettext

DEPENDS = "gettext-native python3-future-native python3"

SRC_URI = "git://github.com/oe-mirrors/e2iplayer.git;branch=python3;protocol=https \
	file://no-need-to-check-depends.patch \
"

S = "${WORKDIR}/git"

PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"

RDEPENDS:${PN} = " \
	python3-core \
	python3-e2icjson \
	python3-json \
	python3-pycurl \
	python3-html \
	python3-shell \
	python3-compression \
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
	${@bb.utils.contains("python3", "python3", "python3-subprocess", "", d)} \
        ${@bb.utils.contains("python3", "python3", "python3-textutils", "", d)} \
	"

RDEPENDS:{PN}-src = "${PN}"

FILES:${PN}-src = " \
	${libdir}/enigma2/python/Plugins/*-py3.10.egg-info/* \
        ${libdir}/enigma2/python/Plugins/*-py2.7.egg-info/* \
        ${libdir}/enigma2/python/Plugins/*/locale/*/LC_MESSAGES/*.po \
        "

deltask package_qa

FILES:${PN} += "${sysconfdir}"
