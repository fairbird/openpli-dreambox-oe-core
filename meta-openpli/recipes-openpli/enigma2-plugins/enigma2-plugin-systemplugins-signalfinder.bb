DESCRIPTION = "Signal finder for DVB-S2 tuners"
HOMEPAGE = "https://github.com/Dima73/enigma2-plugin-signalfinder"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://src/__init__.py;md5=7ac668f257efb8bfb222b04dc0c847ff"

SRC_URI = "git://github.com/Dima73/enigma2-plugin-signalfinder.git;protocol=https"

S = "${WORKDIR}/git"

inherit gitpkgv
PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"

inherit distutils-openplugins
