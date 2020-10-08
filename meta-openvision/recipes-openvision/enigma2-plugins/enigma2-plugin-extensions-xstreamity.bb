SUMMARY = "IPTV Xtream Codes playlists player by KiddaC"
HOMEPAGE = "https://www.linuxsat-support.com"
MAINTAINER = "kiddac"
PRIORITY = "optional"
require conf/license/license-gplv2.inc

RDEPENDS_${PN} = "python-argparse python-image python-imaging python-lzma python-multiprocessing python-requests"

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

inherit gitpkgv rm_python_pyc compile_python_pyo no_python_src rm_language_po

SRC_URI = "git://github.com/kiddac/XStreamity.git"

S = "${WORKDIR}/git"

FILES_${PN} = " ${libdir}/enigma2/python/Components/Converter/* \
                ${libdir}/enigma2/python/Components/Renderer/* \
                ${libdir}/enigma2/python/Plugins/Extensions/XStreamity/*"

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
