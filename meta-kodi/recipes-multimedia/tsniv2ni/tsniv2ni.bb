DESCRIPTION = "Converts TS ETI V.11 streams to ETI NI G.703"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2" 

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/satdreamgr/tsniv2ni.git;protocol=https"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig

TARGET_CC_ARCH += "${LDFLAGS}"
