SUMMARY = "Enigma2 plugin to manage your youtube account and watch videos"
DESCRIPTION = "Small plugin to manage your account, search and watch videos \
from youtube"
HOMEPAGE = "https://github.com/Taapat/enigma2-plugin-youtube"
SECTION = "multimedia"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://COPYING.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263"
require classes/python3-compileall.inc

SRC_URI = " git://github.com/Taapat/enigma2-plugin-youtube.git;protocol=https;branch=master \
			file://0001-Add_option_to_choose_style_of_VirtualKeyBoard.patch \
"

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
