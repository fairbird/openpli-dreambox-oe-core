SUMMARY = "get weather forecasts from MSN-Weather and/or OpenWeatherMap (OWM)"
MAINTAINER = "Mr.Servo and jbleyel"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
require conf/license/license-gplv2.inc
require classes/python3-compileall.inc

inherit gitpkgv
PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

SRC_URI="git://github.com/openatv/WeatherInfo.git;branch=main;protocol=https"

S = "${WORKDIR}/git"

FILES:${PN} = "${libdir}"

do_install() {
    install -d ${D}${libdir}/enigma2/python/Tools
    install -m 0644 ${S}/Weatherinfo.py ${D}${libdir}/enigma2/python/Tools/Weatherinfo.py
}

do_package_qa[noexec] = "1"
