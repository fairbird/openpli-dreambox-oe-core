SUMMARY = "Imports xmltv files into the EPG cache of enigma2"
MAINTAINER = "oe-alliance"
require classes/python3-compileall.inc

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://../etc/epgimport/readme.txt;startline=1;endline=4;md5=c162054328d930d453543efef81be1d8"

inherit gitpkgv gettext python3native

PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"
PR = "r1"

SRC_URI = "git://github.com/oe-alliance/XMLTV-Import.git;protocol=https;branch=python3 \
	file://Remove-unused-codes.patch \
"

S = "${WORKDIR}/git/src"

inherit setuptools3-openplugins

RDEPENDS:${PN} = "python3-compression python3-shell python3-backports-lzma python3-pkgutil"
RRECOMMENDS:${PN} = "${PN}-rytec"

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

do_package_qa[noexec] = "1"
