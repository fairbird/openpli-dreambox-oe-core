DESCRIPTION = "NetSpeedTest plugin by mfaraj57"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/fairbird/NetSpeedTest;protocol=https;branch=master"

inherit gitpkgv setuptools3-openplugins gettext

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
PV = "1.1+git"
PKGV = "1.1+git${GITPKGV}"
