DESCRIPTION = "Display FRITZ!box-Fon calls on screen"
MAINTAINER = "DrMichael"
LICENSE = "CC-BY-NC-SA-3.0"
LIC_FILES_CHKSUM = "file://src/LICENSE;md5=ca0fd7efc85d7f5d417c882290c4b9fa"

RDEPENDS:${PN} = "python3-twisted-web python3-html python3-json python3-six"

inherit gitpkgv setuptools3-openplugins gettext

SRC_URI = "\
	git://github.com/DrMichael/FritzCall.git;protocol=https;branch=master \
	file://git/setup.py \
	file://git/setup_translate.py \
	"

PV = "git"
PKGV = "git${GITPKGV}"

S="${WORKDIR}/git"
