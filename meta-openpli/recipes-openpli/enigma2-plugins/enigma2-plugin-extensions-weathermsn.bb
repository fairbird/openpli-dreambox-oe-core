DESCRIPTION = "Weather forecast for 5 days"
SUMMARY = "Weather MSN"
MAINTAINER = "Sirius"
LICENSE = "GPL-3.0-only+"
HOMEPAGE = "www.gisclub.tv"
LIC_FILES_CHKSUM = "file://python/Plugins/Extensions/WeatherMSN/plugin.py;beginline=3;endline=19;md5=ffc4a5bf0cc661f90242506d3c0fed50"

inherit gitpkgv allarch
require classes/python3-compileall.inc

SRCREV = "${AUTOREV}"
PV = "0.7+git${SRCPV}"
PKGV = "0.7+git${GITPKGV}"

SRC_URI = "git://github.com/Sirius0103/enigma2-plugins.git;protocol=https;branch=master"

FILES:${PN} = "${libdir}/enigma2/"

S = "${WORKDIR}/git"

do_compile:append() {
    python3 -O -m compileall ${S}
}

do_install() {
	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions
	cp -fr --preserve=links ${S}/python/Plugins/Extensions/WeatherMSN ${D}${libdir}/enigma2/python/Plugins/Extensions/
	chmod -R a+rX ${D}${libdir}/enigma2/
}
