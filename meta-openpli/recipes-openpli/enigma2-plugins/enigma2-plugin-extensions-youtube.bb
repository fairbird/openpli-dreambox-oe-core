SUMMARY = "Enigma2 plugin to manage your youtube account and watch videos"
DESCRIPTION = "Small plugin to manage your account, search and watch videos \
from youtube"
HOMEPAGE = "https://github.com/Taapat/enigma2-plugin-youtube"
SECTION = "multimedia"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://COPYING.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263"
require classes/python3-compileall.inc

SRC_URI = " git://github.com/fairbird/Youtube-Opensource-DreamOS.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit gitpkgv
PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"

inherit distutils-openplugins

RDEPENDS:${PN} = " \
	python3-core \
	python3-codecs \
	python3-json \
	python3-netclient \
	python3-pyopenssl \
	python3-twisted-web \
	"

pkg_preinst:${PN} () {
#!/bin/sh
# Add latest hash commit
repo_url="https://github.com/fairbird/Youtube-Opensource-DreamOS/commits/master/src"
hashfile="/usr/lib/enigma2/python/Plugins/Extensions/YouTube/.hashfile"
[ ! $hashfile ] && touch $hashfile
wget -q -O- $repo_url | sed -ne 's#.*data-url="/fairbird/Youtube-Opensource-DreamOS/commits/\([^$<]*\)/commits_list_item".*#\1#p' | cut -d "=" -f2 | head -n 1 > $hashfile
}
