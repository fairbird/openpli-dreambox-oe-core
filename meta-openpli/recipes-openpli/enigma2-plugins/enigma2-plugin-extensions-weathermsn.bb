DESCRIPTION = "Weather forecast for 5 days"
SUMMARY = "Weather MSN"
MAINTAINER = "Sirius"
LICENSE = "GPL-3.0-or-later"
HOMEPAGE = "www.gisclub.tv"
require conf/license/license-gplv2.inc

inherit gitpkgv python3native python3-compileall

SRCREV = "${AUTOREV}"
PV = "1.3.+git"
PKGV = "1.3.+git${GITPKGV}"

SRC_URI = "git://github.com/oe-mirrors/enigma2-plugins.git;protocol=https;branch=master"

FILES:${PN} = "${libdir}/enigma2/"
do_install() {
	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions
	cp -fr --preserve=links ${S}/python/Plugins/Extensions/WeatherMSN ${D}${libdir}/enigma2/python/Plugins/Extensions/
	chmod -R a+rX ${D}${libdir}/enigma2/
}


