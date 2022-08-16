SUMMARY = "Libav-based GStreamer 1.x plugin"
SECTION = "multimedia"
HOMEPAGE = "http://www.gstreamer.net/"
LICENSE = "GPL-2.0-only & LGPL-2.0-only & ( (GPL-2.0-only & LGPL-2.1-only) | (GPL-3.0-only & LGPL-3.0-only) )"
LICENSE_FLAGS = "commercial"
LIC_FILES_CHKSUM = "file://COPYING;md5=69333daa044cb77e486cc36129f7a770"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base ffmpeg"

inherit meson pkgconfig

require gstreamer1.0-common.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=69333daa044cb77e486cc36129f7a770"

SRC_URI = "git://github.com/GStreamer/gst-libav.git;protocol=https;branch=master"

FILES:${PN} += "${libdir}/gstreamer-1.0/*.so"
FILES:${PN}-dbg += "${libdir}/gstreamer-1.0/.debug"
FILES:${PN}-dev += "${libdir}/gstreamer-1.0/*.la"
FILES:${PN}-staticdev += "${libdir}/gstreamer-1.0/*.a"
