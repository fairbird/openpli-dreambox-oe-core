DESCRIPTION = "ReadyMedia DLNA server (formerly aka MiniDLNA)"
SUMMARY = "lightweight DLNA/UPnP-AV server targeted at embedded systems"
HOMEPAGE = "http://sourceforge.net/projects/minidlna"
SECTION = "multimedia"
MAINTAINER = "OpenPLi"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENCE.miniupnpd;md5=b0dabf9d8e0f871554e309d62ead8d2b"

inherit gitpkgv

PV = "1.1.0+git${SRCPV}"
PKGV = "1.1.0+git${GITPKGV}"
PR = "r0"
DEPENDS = "libexif libav libjpeg-turbo libid3tag libvorbis sqlite3 flac"

SRC_URI = "git://github.com/OpenVisionE2/minidlna.git;protocol=https;branch=master \
			file://readymedia.sh \
			file://minidlna.conf \
"
S = "${WORKDIR}/git"

do_configure:prepend() {
		sed -i 's/AM_INIT_AUTOMAKE.*$/AM_INIT_AUTOMAKE([foreign subdir-objects])/' ${S}/configure.ac
}

CONFFILES:${PN} = "${sysconfdir}/minidlna.conf"

inherit autotools-brokensep pkgconfig gettext update-rc.d

INITSCRIPT_NAME = "readymedia.sh"
INITSCRIPT_PARAMS = "stop 00 0 6 ."

do_install:append() {
	install -m 755 -d ${D}${sysconfdir}
	install -m 644 ${WORKDIR}/minidlna.conf ${D}${sysconfdir}/
	install -m 755 -d ${D}${sysconfdir}/init.d/
	install -m 755 ${WORKDIR}/readymedia.sh ${D}${sysconfdir}/init.d/
	install -m 755 -d ${D}${localstatedir}/lib/readymedia/
}
