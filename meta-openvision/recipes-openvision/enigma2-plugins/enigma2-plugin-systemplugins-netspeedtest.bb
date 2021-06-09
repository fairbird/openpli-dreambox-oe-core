DESCRIPTION = "NetSpeedTest plugin by mfaraj57"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/OpenVisionE2/NetSpeedTest;protocol=git"

inherit gitpkgv distutils-openplugins gettext

S = "${WORKDIR}/git"

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
