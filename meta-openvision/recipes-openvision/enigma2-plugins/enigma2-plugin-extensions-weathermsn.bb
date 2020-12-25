DESCRIPTION = "Weather forecast for 5 days"
SUMMARY = "Weather MSN"
MAINTAINER = "Sirius"
LICENSE = "GPLv3+"
HOMEPAGE = "www.gisclub.tv"
LIC_FILES_CHKSUM = "file://python/Plugins/Extensions/WeatherMSN/plugin.py;beginline=3;endline=19;md5=10bdcaaaec8041e55835067db0506e8d"

inherit gitpkgv allarch rm_python_pyc compile_python_pyo no_python_src

PV = "0.7+git${SRCPV}"
PKGV = "0.7+git${GITPKGV}"

SRC_URI = "git://github.com/Sirius0103/enigma2-plugins.git;protocol=https"

FILES_${PN} = "${libdir}/enigma2/"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions
	cp -fr --preserve=links ${S}/python/Plugins/Extensions/WeatherMSN ${D}${libdir}/enigma2/python/Plugins/Extensions/
	chmod -R a+rX ${D}${libdir}/enigma2/
}
