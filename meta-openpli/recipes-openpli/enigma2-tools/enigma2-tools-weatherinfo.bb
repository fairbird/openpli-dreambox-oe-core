SUMMARY = "get weather forecasts from MSN-Weather and/or OpenWeatherMap (OWM)"
MAINTAINER = "Mr.Servo and jbleyel"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
require conf/license/license-gplv2.inc

inherit gitpkgv python3-compileall

PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/openatv/WeatherInfo.git;branch=main;protocol=https"

S = "${UNPACKDIR}/git"

FILES:${PN} = "${libdir}"

do_install() {
    install -d ${D}${libdir}/enigma2/python/Tools
    install -m 0644 ${S}/Weatherinfo.py ${D}${libdir}/enigma2/python/Tools/Weatherinfo.py
}


