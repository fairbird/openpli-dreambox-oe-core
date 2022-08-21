DESCRIPTION = "Infobar Weather plugin"
MAINTAINER = "scriptmelvin"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

inherit gitpkgv distutils-openplugins gettext

PV = "2.0+git${SRCPV}"
PKGV = "2.0+git${GITPKGV}"

SRC_URI = "git://github.com/scriptmelvin/enigma2-plugin-extensions-infobarweather.git;protocol=https;branch=main"

S="${WORKDIR}/git"

do_install:append() {
	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/InfoBarWeather/locale
	cp -rf ${S}/build/lib/Extensions/InfoBarWeather/locale/ ${D}/${libdir}/enigma2/python/Plugins/Extensions/InfoBarWeather/
}
