SUMMARY = "E2iPlayer"
DESCRIPTION = "Watch Videos Online"
HOMEPAGE = "https://gitlab.com/iptvplayer-for-e2/"
SECTION = "multimedia"
LICENSE = "GPL-2.0-only"
require conf/license/license-gplv2.inc

SRC_URI = "git://github.com/oe-mirrors/e2iplayer.git;branch=python3;protocol=https \
	file://no-need-to-check-depends.patch \
"

S = "${WORKDIR}/git"

inherit gitpkgv
PV = "git"
PKGV = "git${GITPKGV}"
PR = "r0"

inherit distutils-openplugins gettext

DEPENDS = "gettext-native ${PYTHON_PN}-future-native ${PYTHON_PN}"
RRECOMMENDS:${PN} = " \
        enigma2-plugin-extensions-e2iplayer-deps \
        ${PYTHON_PN}-compression \
        ${PYTHON_PN}-core \
        ${PYTHON_PN}-html \
        ${PYTHON_PN}-e2icjson \
        ${PYTHON_PN}-json \
        ${PYTHON_PN}-shell \
        "

RDEPENDS:{PN}-src = "${PN}"

FILES:${PN}-src = " \
	${libdir}/enigma2/python/Plugins/*-py${PYTHON_BASEVERSION}.egg-info/* \
	${libdir}/enigma2/python/Plugins/*-py2.7.egg-info/* \
	${libdir}/enigma2/python/Plugins/*/locale/*/LC_MESSAGES/*.po \
	"

deltask package_qa
