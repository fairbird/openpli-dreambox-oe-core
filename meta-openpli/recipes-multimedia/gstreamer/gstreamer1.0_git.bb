SUMMARY = "GStreamer 1.0 multimedia framework"
DESCRIPTION = "GStreamer is a multimedia framework for encoding and decoding video and sound. \
It supports a wide range of formats including mp3, ogg, avi, mpeg and quicktime."
HOMEPAGE = "http://gstreamer.freedesktop.org/"
BUGTRACKER = "https://bugzilla.gnome.org/enter_bug.cgi?product=Gstreamer"
SECTION = "multimedia"
LICENSE = "LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=69333daa044cb77e486cc36129f7a770"

require gstreamer1.0-common.inc

DEPENDS = "glib-2.0 glib-2.0-native libcap libxml2 bison-native flex-native"

inherit meson pkgconfig gettext upstream-version-is-even

SRC_URI = " git://github.com/GStreamer/gstreamer.git;protocol=https;branch=master \
			file://001-revert-use-new-gst-adapter-get-buffer.patch \
"

PACKAGECONFIG ??= ""

PACKAGES += "${PN}-bash-completion"

FILES:${PN} += "${libdir}/gstreamer-1.0/*.so /usr/share/"
FILES:${PN}-dev += "${libdir}/gstreamer-1.0/*.la ${libdir}/gstreamer-1.0/*.a ${libdir}/gstreamer-1.0/include"
FILES:${PN}-bash-completion += "${datadir}/bash-completion/completions/ ${datadir}/bash-completion/helpers/gst*"
