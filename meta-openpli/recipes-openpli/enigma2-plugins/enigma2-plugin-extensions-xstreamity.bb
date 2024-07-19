SUMMARY = "IPTV Xtream Codes playlists player by KiddaC"
HOMEPAGE = "https://www.linuxsat-support.com"
MAINTAINER = "kiddac"
PRIORITY = "optional"
require conf/license/license-gplv2.inc
require classes/python3-compileall.inc

RDEPENDS:${PN} = "python3 python3-multiprocessing python3-requests \
                  python3-imaging python3-pillow \
"

SRCREV = "${AUTOREV}"
PV = "3.71+git"
PKGV = "3.71+git${GITPKGV}"
PR = "r0"

inherit gitpkgv

SRC_URI = "git://github.com/kiddac/XStreamity.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

FILES:${PN} = " ${libdir}/enigma2/python/Components/Converter/* \
                ${libdir}/enigma2/python/Components/Renderer/* \
                ${libdir}/enigma2/python/Plugins/Extensions/XStreamity/*"

do_compile:append() {
    python3 -O -m compileall ${S}
}

do_install() {
    install -d ${D}${libdir}/enigma2/python/Components/Converter
    install -d ${D}${libdir}/enigma2/python/Components/Renderer
    install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/XStreamity
    cp -rf ${S}/XStreamity${libdir}/enigma2/python/Components/Converter/*.pyc ${D}${libdir}/enigma2/python/Components/Converter/
    cp -rf ${S}/XStreamity${libdir}/enigma2/python/Components/Renderer/*.pyc ${D}${libdir}/enigma2/python/Components/Renderer/
    rm -f ${S}/XStreamity${libdir}/enigma2/python/Plugins/Extensions/XStreamity/owibranding.pyo
    cp -rf ${S}/XStreamity${libdir}/enigma2/python/Plugins/Extensions/XStreamity/* ${D}${libdir}/enigma2/python/Plugins/Extensions/XStreamity/
}

pkg_preinst:${PN}() {
#!/bin/sh
if [ -f "${sysconfdir}/enigma2/X-Streamity/playlists.json" ]
	then
	rm -f ${sysconfdir}/enigma2/X-Streamity/playlists.json > /dev/null 2>&1
fi

if [ -f "${sysconfdir}/enigma2/xstreamity/playlists.json" ]
	then
	rm -f ${sysconfdir}/enigma2/xstreamity/playlists.json > /dev/null 2>&1
fi

if [ -f "${sysconfdir}/enigma2/xstreamity/x-playlists.json" ]
	then
	rm -f ${sysconfdir}/enigma2/xstreamity/x-playlists.json > /dev/null 2>&1
fi
}

do_install:append() {
    find ${D}/ -name '*.py' -exec rm {} \;
    find ${D}/ -name '*.po' -exec rm {} \;
    find ${D}/ -name '*.egg-info' -exec rm {} \;
    # make scripts executable
    find "${D}" -name '*.sh' -exec chmod a+x '{}' ';'
}

do_package_qa[noexec] = "1"
