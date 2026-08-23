SUMMARY = "Enigma2 plugin to play Blu-ray discs"
DESCRIPTION = "Small plugin to to play Blu-ray discs"
HOMEPAGE = "https://github.com/Taapat/enigma2-plugin-blurayplayer"
SECTION = "multimedia"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit gitpkgv python3native python3-compileall

PV = "1+git"
PKGV = "1+git${GITPKGV}"
BRANCH = "master"
PR = "r4"

SRC_URI = "git://github.com/oe-alliance-mirrors/enigma2-plugin-blurayplayer.git;protocol=https;branch=${BRANCH} \
    file://aacs/README.openpli \
"

inherit setuptools3-openplugins

DEPENDS += "python3  libbluray libudfread"
RDEPENDS:${PN} = "libbluray libaacs"

do_install:append() {
	install -d ${D}${sysconfdir}/xdg/aacs
	install -m 0644 ${UNPACKDIR}/aacs/README.openpli ${D}${sysconfdir}/xdg/aacs/README.openpli
}

FILES:${PN} += "${sysconfdir}/xdg/aacs/README.openpli"

FILES:${PN}-dbg += "/usr/lib/enigma2/python/Plugins/Extensions/BlurayPlayer/.debug"
