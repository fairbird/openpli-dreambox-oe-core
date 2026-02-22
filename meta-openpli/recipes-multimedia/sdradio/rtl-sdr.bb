SUMMARY = "Software to turn the RTL2832U into an SDR"
DESCRIPTION = "DVB-T dongles based on the Realtek RTL2832U can be used as a cheap SDR, since the chip allows transferring the raw I/Q samples to the host, which is officially used for DAB/DAB+/FM demodulation"
MAINTAINER = "http://osmocom.org/projects/sdr"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

inherit gitpkgv cmake pkgconfig

PV = "git"
PKGV = "${GITPKGV}"

SRC_URI = "git://git.osmocom.org/rtl-sdr;protocol=https;branch=master"

DEPENDS = "libusb1"

EXTRA_OECMAKE += " -DLIB_INSTALL_DIR=${libdir}"

EXTRA_OECONF = "--enable-driver-detach"

# next...
#do_install:append() {
#	# some programs try to load librtlsdr.so
#	cd ${D}${libdir}
#	ln -sf librtlsdr.so.0 librtlsdr.so
#}
