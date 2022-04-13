DESCRIPTION = "gstreamer dvbmediasink plugin"
SECTION = "multimedia"
PRIORITY = "optional"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base libdca glib-2.0 glib-2.0-native"

PROVIDES += "virtual/gstreamer1.0-mediasink"
RPROVIDES:${PN} += "virtual/gstreamer1.0-dvbmediasink"

GSTVERSION = "1.0"

SRC_URI = "git://github.com/christophecvr/gstreamer1.0-plugin-multibox-dvbmediasink;branch=openatv-dev;protocol=https"

S = "${WORKDIR}/git"

inherit gitpkgv

PV = "${GSTVERSION}+git${SRCPV}"
PKGV = "${GSTVERSION}+git${GITPKGV}"
PR = "r0"

do_configure:prepend() {
        sed -i 's/AC_INIT.*$/AC_INIT(gst-plugin-dvbmediasink, 1.0.0, @pli4)/' ${S}/configure.ac
        sed -i 's/AM_INIT_AUTOMAKE.*$/AM_INIT_AUTOMAKE([foreign])/' ${S}/configure.ac
}

inherit autotools pkgconfig

FILES:${PN} = "${libdir}/gstreamer-${GSTVERSION}/*.so*"
FILES:${PN}-dev += "${libdir}/gstreamer-${GSTVERSION}/*.la"
FILES:${PN}-staticdev += "${libdir}/gstreamer-${GSTVERSION}/*.a"
FILES:${PN}-dbg += "${libdir}/gstreamer-${GSTVERSION}/.debug"

PACKAGE_ARCH = "${MACHINE_ARCH}"

EXTRA_OECONF = "${DVBMEDIASINK_CONFIG} --with-gstversion=${GSTVERSION}"
