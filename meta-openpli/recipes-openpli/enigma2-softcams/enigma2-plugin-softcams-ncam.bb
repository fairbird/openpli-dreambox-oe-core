MAINTAINER = "RAED Developer"
require conf/license/openpli-gplv2.inc
require softcam.inc
inherit cmake gitpkgv

DESCRIPTION = "ncam ${PV} Open Source Softcam"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PV = "git"
PKGV = "git${GITPKGV}"
SRC_URI = "git://github.com/fairbird/NCam.git;protocol=https;branch=master"

DEPENDS = "libusb openssl libdvbcsa"

LDFLAGS:prepend = "-ludev -ldvbcsa "
EXTRA_OECONF = "LIBDVBCSA=yes "

S = "${WORKDIR}/git"
B = "${S}"

CAMNAME = "ncam"
CAMSTART = "exec start-stop-daemon -S -x /usr/bin/ncam -- -b -r 2 -c /etc/tuxbox/config"
CAMSTOP =  "exec start-stop-daemon -K -R 2 -x /usr/bin/ncam"

SRC_URI += "\
	file://ncam.conf \
	file://ncam.server \
	file://ncam.srvid \
	file://ncam.user \
	file://ncam.provid \
	file://CCcam.cfg \
	file://ncam.fs \
	file://ncam.services"

CONFFILES = "/etc/tuxbox/config/ncam.conf /etc/tuxbox/config/ncam.server /etc/tuxbox/config/ncam.srvid /etc/tuxbox/config/ncam.user /etc/tuxbox/config/ncam.provid /etc/tuxbox/config/CCcam.cfg /etc/tuxbox/config/ncam.services"

FILES:${PN} = "/usr/bin/ncam /etc/tuxbox/config/* /etc/init.d/softcam.ncam"

EXTRA_OECMAKE += "\
	-DOSCAM_SYSTEM_NAME=Tuxbox \
	-DWEBIF=1 \
	-DWITH_STAPI=0 \
	-DWITH_LIBCUR=1 \
	-DWITH_LIBCRYPTO=1 \
	-DHAVE_LIBUSB=1 \
	-DSTATIC_LIBUSB=1 \
	-DWITH_SSL=1 \
	-DIPV6SUPPORT=1 \
	-DCLOCKFIX=0 \
	-DHAVE_PCSC=1 \
	-DCARDREADER_SMARGO=1 \
	-DCARDREADER_PCSC=1 \
	-DCW_CYCLE_CHECK=1 \
	-DCS_CACHEEX=1 \
	-DMODULE_STREAMRELAY=1 \
	"

do_install() {
	install -d ${D}/etc/tuxbox/config/ncam
	install -m 0644 ${WORKDIR}/ncam.* ${D}/etc/tuxbox/config/
	install -d ${D}/usr/bin
	install -m 0755 ${B}/ncam ${D}/usr/bin
}
