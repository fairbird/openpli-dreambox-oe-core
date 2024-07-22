DESCRIPTION = "enigma2-plugin-extensions-yahooweather"
MAINTAINER = "original by m43c0 and mmark and mod by mogli123"
SECTION = "extra"
PRIORITY = "optional"
require conf/license/license-gplv2.inc
require classes/python3-compileall.inc

inherit gitpkgv python3native autotools-brokensep gettext

PV = "1.2.+git"
PKGV = "1.2.+git${GITPKGV}"
PR = "r0"

SRC_URI="git://github.com/oe-alliance/YahooWeather.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
"

do_configure:prepend() {
sed -i 's/python/python3/g' ${S}/xml2po.py
}


PARALLEL_MAKEINST = ""

CONFFILES:${PN} = " \
    ${libdir}/enigma2/python/Plugins/Extensions/YahooWeather/Config/Location_id \
    ${libdir}/enigma2/python/Plugins/Extensions/YahooWeather/Config/Region_id "

PACKAGES =+ "${PN}-po"
FILES:${PN} = "${libdir}"
FILES:${PN}-src = "${libdir}/enigma2/python/Plugins/Extensions/YahooWeather/*.py"
FILES:${PN}-po = "${libdir}/enigma2/python/Plugins/Extensions/YahooWeather/locale/*/*/*.po"

pkg_postinst:${PN}() {
#!/bin/sh
echo ""
echo "YahooWeather successfully installed!"
echo ""
echo ""
exit 0
}

pkg_postrm:${PN}() {
#!/bin/sh
rm -r /usr/lib/enigma2/python/Plugins/Extensions/YahooWeather
echo " YahooWeather removed! You should restart enigma2 now!"
exit 0
}


