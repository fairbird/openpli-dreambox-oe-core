DESCRIPTION = "plugin to connect to internet via any modems"
HOMEPAGE = "https://github.com/Dima73/enigma2-plugin-extensions-xmodem"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://README;md5=00f286ed22b8ad579d0715884c7639a9"
require classes/python3-compileall.inc

SRC_URI = "git://github.com/Dima73/enigma2-plugin-extensions-xmodem.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit gitpkgv

PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"

inherit distutils-openplugins

RDEPENDS:${PN} = " \
	iptables \
	usb-modeswitch \
	usb-modeswitch-data \
	picocom \
	ppp \
"
