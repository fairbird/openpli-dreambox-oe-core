SUMMARY = "Enigma2 plugin to manage your youtube account and watch videos"
DESCRIPTION = "Small plugin to manage your account, search and watch videos \
from youtube"
HOMEPAGE = "https://github.com/Taapat/enigma2-plugin-youtube"
SECTION = "multimedia"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://COPYING.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = " git://github.com/fairbird/Youtube-Opensource-DreamOS.git;protocol=https;branch=master"
inherit gitpkgv setuptools3-openplugins python3-compileall

PV = "1+git"
PKGV = "1+git${GITPKGV}"

RDEPENDS:${PN} = " \
	python3-core \
	python3-datetime \
	python3-email \
	python3-json \
	python3-io \
	"

do_install:append() {
    install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/YouTube
    HASH_FILE="${D}${libdir}/enigma2/python/Plugins/Extensions/YouTube/.hashfile"
    # Get the full SHA from the fetched git repository
    cd ${S}
    git rev-parse HEAD > $HASH_FILE
}
