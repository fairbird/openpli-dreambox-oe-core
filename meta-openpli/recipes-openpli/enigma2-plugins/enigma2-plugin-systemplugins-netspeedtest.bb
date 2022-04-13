DESCRIPTION = "NetSpeedTest plugin by mfaraj57"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
require classes/python3-compileall.inc

SRC_URI = "git://github.com/OpenVisionE2/NetSpeedTest;protocol=https;branch=master"

inherit gitpkgv distutils-openplugins gettext

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
PV = "1.1+git${SRCPV}"
PKGV = "1.1+git${GITPKGV}"
