DESCRIPTION = "Search the internet bases themoviedb.org/kinopoisk.ru"
HOMEPAGE = "https://github.com/Dima73/enigma2-plugin-extensions-tmbd"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://README;md5=a1f8725511fa113a2b2a282860d4fc19"
require classes/python3-compileall.inc

SRC_URI = "git://github.com/Hains/enigma2-plugin-extensions-tmbd.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit gitpkgv
PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"

inherit distutils-openplugins

RDEPENDS:${PN} = " \
	python3-twisted-web \
	python3-xml \
	python3-shell \
	python3-misc \
	python3-html \
	python3-unixadmin \
	python3-lxml \
	"
