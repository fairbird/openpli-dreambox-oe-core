SUMMARY = "E2iPlayer"
DESCRIPTION = "Watch Videos Online"
HOMEPAGE = "https://gitlab.com/iptvplayer-for-e2/"
SECTION = "multimedia"
LICENSE = "GPL-2.0-only"
require conf/license/license-gplv2.inc

SRC_URI = "git://gitlab.com/MOHAMED_OS/e2iplayer.git;branch=main;protocol=https \
	file://no-need-to-check-depends.patch \
"

S = "${WORKDIR}/git"

inherit gitpkgv
PV = "git"
PKGV = "git${GITPKGV}"
PR = "r0"

inherit setuptools3-openplugins gettext

DEPENDS = "gettext-native python3-future-native python3"
RRECOMMENDS:${PN} = " \
        enigma2-plugin-extensions-e2iplayer-deps \
        python3-compression \
        python3-core \
        python3-html \
        python3-e2icjson \
        python3-json \
        python3-shell \
        "

do_install:append() {
    rm -rf ${D}/${libdir}/enigma2/python/Plugins/Extensions/IPTVPlayer/bin
}

RDEPENDS:{PN}-src = "${PN}"

FILES:${PN}-src = " \
	${libdir}/enigma2/python/Plugins/*-py${PYTHON_BASEVERSION}.egg-info/* \
	${libdir}/enigma2/python/Plugins/*-py2.7.egg-info/* \
	${libdir}/enigma2/python/Plugins/*/locale/*/LC_MESSAGES/*.po \
	"

deltask package_qa
