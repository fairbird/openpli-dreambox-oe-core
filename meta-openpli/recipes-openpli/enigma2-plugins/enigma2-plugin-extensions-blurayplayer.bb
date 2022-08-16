SUMMARY = "Enigma2 plugin to play Blu-ray discs"
DESCRIPTION = "Small plugin to to play Blu-ray discs"
HOMEPAGE = "https://github.com/Taapat/enigma2-plugin-blurayplayer"
SECTION = "multimedia"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING.GPL-2.0-only;md5=b234ee4d69f5fce4486a80fdaf4a4263"
require classes/python3-compileall.inc

DEPENDS = "libbluray libudfread"

inherit gitpkgv
PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"
BRANCH = "openpli"

SRC_URI = "git://github.com/Taapat/enigma2-plugin-blurayplayer.git;branch=${BRANCH};protocol=https"

S = "${WORKDIR}/git"

inherit distutils-openplugins

FILES:${PN}-dbg += "${libdir}/enigma2/python/Plugins/Extensions/BlurayPlayer/.debug"
