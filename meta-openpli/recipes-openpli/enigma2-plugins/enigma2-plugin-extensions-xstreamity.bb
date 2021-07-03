SUMMARY = "IPTV Xtream Codes playlists player by KiddaC"
HOMEPAGE = "https://www.linuxsat-support.com"
MAINTAINER = "kiddac"
PRIORITY = "optional"
require conf/license/license-gplv2.inc

RDEPENDS_${PN} = "python-argparse python-image python-imaging python-lzma python-multiprocessing python-requests"

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

inherit gitpkgv

SRC_URI = "git://github.com/kiddac/XStreamity.git"

S = "${WORKDIR}/git"

FILES_${PN} = " ${libdir}/enigma2/python/Components/Converter/* \
                ${libdir}/enigma2/python/Components/Renderer/* \
                ${libdir}/enigma2/python/Plugins/Extensions/XStreamity/*"

do_compile_append() {
    python2 -O -m compileall ${S}
}

do_install() {
    install -d ${D}${libdir}/enigma2/python/Components/Converter
    install -d ${D}${libdir}/enigma2/python/Components/Renderer
    install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/XStreamity
    cp -rf ${S}/XStreamity${libdir}/enigma2/python/Components/Converter/*.pyo ${D}${libdir}/enigma2/python/Components/Converter/
    cp -rf ${S}/XStreamity${libdir}/enigma2/python/Components/Renderer/*.pyo ${D}${libdir}/enigma2/python/Components/Renderer/
    rm -f ${S}/XStreamity${libdir}/enigma2/python/Plugins/Extensions/XStreamity/owibranding.pyo
    cp -rf ${S}/XStreamity${libdir}/enigma2/python/Plugins/Extensions/XStreamity/* ${D}${libdir}/enigma2/python/Plugins/Extensions/XStreamity/
}

pkg_preinst_${PN}() {
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

do_install_append() {
    find ${D}/ -name '*.pyc' -exec rm {} \;
    find ${D}/ -name '*.po' -exec rm {} \;
    find ${D}/ -name '*.egg-info' -exec rm {} \;
    # make scripts executable
    find "${D}" -name '*.sh' -exec chmod a+x '{}' ';'
}
