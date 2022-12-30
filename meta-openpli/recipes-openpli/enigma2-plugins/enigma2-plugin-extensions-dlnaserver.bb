DESCRIPTION = "DLNA Server plugin"
MAINTAINER = "OpenPLi"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

inherit python3native

PV = "0.2"

SRC_URI = "file://__init__.py \
           file://plugin.py \
"
RDEPENDS:${PN} = "minidlna"

S = "${WORKDIR}"
FILES:${PN} = "${libdir}/enigma2/python/Plugins/Extensions/DLNAServer/*"
PACKAGES = "${PN}"

do_install() {
	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/DLNAServer
	install -m 0644 ${S}/*.py ${D}${libdir}/enigma2/python/Plugins/Extensions/DLNAServer/
	python3 -O -m compileall ${D}${libdir}/enigma2/python/Plugins/
}
