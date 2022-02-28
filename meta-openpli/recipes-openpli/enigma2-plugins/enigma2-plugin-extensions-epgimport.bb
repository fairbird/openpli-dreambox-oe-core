DESCRIPTION = "Imports XMLTV and epg.dat files into the EPG cache of enigma2"
MAINTAINER = "OpenPLi team"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../etc/epgimport/readme.txt;startline=1;endline=4;md5=c162054328d930d453543efef81be1d8"

inherit gitpkgv pythonnative gettext
require classes/python3-compileall.inc

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/oe-alliance/XMLTV-Import.git;protocol=https;branch=master \
	file://Remove-unused-codes.patch;apply=yes \
"

S = "${WORKDIR}/git/src"

inherit distutils-openplugins

DEPENDS = "python3"
RDEPENDS:${PN} = "python3-compression python3-shell python-lzma python3-pkgutil"
RRECOMMENDS:${PN} = "${PN}-rytec"
PACKAGES = "${PN}-dbg ${PN}"

RREPLACES:${PN} = "enigma2-plugin-extensions-xmltvimport"
RCONFLICTS:${PN} = "enigma2-plugin-extensions-xmltvimport"

PLUGIN = "EPGImport"

FILES:${PN} = "${libdir}/enigma2/python/Plugins/Extensions/${PLUGIN}/ /etc"
FILES:${PN}-dbg = "${libdir}/enigma2/python/Plugins/Extensions/${PLUGIN}/.debug /usr/src/debug"
FILES:${PN}-src = "${libdir}/enigma2/python/Plugins/Extensions/${PLUGIN}/*.py"

# skip this!
install_egg_info() {
}

do_install:prepend (){
	install -d ${D}/${sysconfdir}/epgimport
	install -m 755 ${S}/../etc/epgimport/readme.txt ${D}${sysconfdir}/epgimport/readme.txt
}
