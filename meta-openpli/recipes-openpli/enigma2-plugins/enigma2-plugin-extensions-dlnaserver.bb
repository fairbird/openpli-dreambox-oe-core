DESCRIPTION = "VU+ DLNA Server plugin"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c9e255efa454e0155c1fd758df7dcaf3"
BRANCH = "vuplus_experimental"
S = "${WORKDIR}/git"
SRC_URI = "git://code.vuplus.com/git/dvbapp.git;protocol=http;branch=${BRANCH} \
	file://01-minidlna.patch;striplevel=1;apply=yes \
	file://02-readymedia.patch;striplevel=1;apply=yes \
	file://fix_compile_error_py3.patch;striplevel=1;apply=yes \
"

inherit gitpkgv
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

FILES:${PN} = "${libdir}/enigma2/python/Plugins/Extensions/DLNAServer/*"
PACKAGES = "${PN}"

do_install() {
	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/DLNAServer
	install -m 0644 ${S}/lib/python/Plugins/Extensions/DLNAServer/*.py ${D}${libdir}/enigma2/python/Plugins/Extensions/DLNAServer
	python3 -O -m compileall ${D}${libdir}/enigma2/python/Plugins/
}

INSANE_SKIP:${PN} += "already-stripped"
