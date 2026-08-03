SUMMARY = "Software-Defined Radio Digital Signal Processing Library"
DESCRIPTION = "liquid-dsp is a free and open-source digital signal processing (DSP) library designed specifically for software-defined radios on embedded platforms."
MAINTAINER = "Joseph D. Gaeddert <joseph@liquidsdr.org>"
HOMEPAGE = "http://liquidsdr.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d3387e10507bb9744bf7f7d15a3d3812"

inherit gitpkgv

PV = "git"
PKGV = "${GITPKGVTAG}"

SRC_URI = "git://github.com/jgaeddert/liquid-dsp.git;protocol=https;branch=master"
inherit autotools-brokensep

do_install() {
	mkdir -p ${D}${libdir}
	mkdir -p ${D}${includedir}/liquid
	install -m 755 -p ${S}/libliquid.so ${D}${libdir}/libliquid.so.0.0
	ln -s libliquid.so.0.0 ${D}${libdir}/libliquid.so
	ln -s libliquid.so.0.0 ${D}${libdir}/libliquid.so.0
	install -m 755 -p ${S}/libliquid.a ${D}${libdir}
	install -m 644 -p ${S}/include/liquid.h ${D}${includedir}/liquid
}

FILES:${PN} = "${libdir}"
FILES:${PN}-dev = "${includedir} ${libdir}/libliquid.a"

INSANE_SKIP:${PN} += "dev-so"
