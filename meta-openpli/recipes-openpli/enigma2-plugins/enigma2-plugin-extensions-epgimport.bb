SUMMARY = "Imports xmltv files into the EPG cache of enigma2"
MAINTAINER = "oe-alliance"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://../etc/epgimport/readme.txt;startline=1;endline=4;md5=c162054328d930d453543efef81be1d8"

inherit gitpkgv gettext python3native python3-compileall setuptools3-openplugins

PV = "1.1+git"
PKGV = "1.1+git${GITPKGV}"
PR = "r1"

SRC_URI = "git://github.com/oe-alliance/XMLTV-Import.git;protocol=https;branch=master \
	file://Remove-unused-codes.patch \
"

S = "${UNPACKDIR}/git/src"

RDEPENDS:${PN} = "python3-compression python3-shell python3-backports-lzma python3-pkgutil"
RRECOMMENDS:${PN} = "${PN}-sources"

PACKAGES = "${PN}-src ${PN}-dbg ${PN}"

PLUGIN = "EPGImport"

FILES:${PN} = "${libdir}/enigma2/python/Plugins/Extensions/${PLUGIN}/ /etc"
FILES:${PN}-dbg = "${libdir}/enigma2/python/Plugins/Extensions/${PLUGIN}/.debug /usr/src/debug"

# skip this!
install_egg_info() {
}

do_install:prepend (){
	install -d ${D}/${sysconfdir}/epgimport
	install -m 755 ${S}/../etc/epgimport/readme.txt ${D}${sysconfdir}/epgimport/readme.txt
}

INSANE_SKIP:${PN} = "installed-vs-shipped"
