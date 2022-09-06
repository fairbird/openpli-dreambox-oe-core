DESCRIPTION = "Weather forecast for 5 days"
SUMMARY = "Weather MSN"
MAINTAINER = "Sirius"
LICENSE = "GPL-3.0-only+"
HOMEPAGE = "www.gisclub.tv"
require conf/license/license-gplv2.inc
require classes/python3-compileall.inc

inherit gitpkgv ${PYTHON_PN}native

SRCREV = "${AUTOREV}"
PV = "1.3.+git${SRCPV}"
PKGV = "1.3.+git${GITPKGV}"

SRC_URI = "git://github.com/oe-mirrors/enigma2-plugins.git;protocol=https;branch=master"

FILES:${PN} = "${libdir}/enigma2/"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions
	cp -fr --preserve=links ${S}/python/Plugins/Extensions/WeatherMSN ${D}${libdir}/enigma2/python/Plugins/Extensions/
	chmod -R a+rX ${D}${libdir}/enigma2/
}
