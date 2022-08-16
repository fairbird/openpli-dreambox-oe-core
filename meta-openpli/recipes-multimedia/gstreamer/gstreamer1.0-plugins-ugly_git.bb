LICENSE = "GPL-2.0-only & LGPL-2.1-only & LGPL-2.0-only"
LICENSE_FLAGS = "commercial"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
					file://tests/check/elements/xingmux.c;beginline=1;endline=21;md5=4c771b8af188724855cb99cadd390068 \
"

require gstreamer1.0-plugins.inc
require gstreamer1.0-common.inc

DEPENDS += "gstreamer1.0-plugins-base"

inherit gettext

SRC_URI = "git://github.com/GStreamer/gst-plugins-ugly.git;protocol=https;branch=master"

PACKAGECONFIG ??= "a52dec amrnb amrwbdec cdio dvdread mpeg2dec orc x264"

PACKAGECONFIG[amrnb]	= "-Damrnb=enabled,-Damrnb=false,opencore-amr"
PACKAGECONFIG[amrwbdec]	= "-Damrwbdec=enabled,-Damrwbdec=false,opencore-amr"
PACKAGECONFIG[a52dec]	= "-Da52dec=enabled,-Dlibwacom=false,liba52"
PACKAGECONFIG[cdio]		= "-Dcdio=enabled,-Dcdio=disabled,libcdio"
PACKAGECONFIG[dvdread]	= "-Ddvdread=enabled,-Ddvdread=disabled,libdvdread"
PACKAGECONFIG[mpeg2dec]	= "-Dmpeg2dec=enabled,-Dmpeg2dec=disabled,mpeg2dec"
PACKAGECONFIG[orc]		= "-Dorc=enabled,-Dorc=disabled,orc"
PACKAGECONFIG[x264]		= "-Dx264=enabled,-Dx264=disabled,x264"

FILES:${PN}-amrnb += "${datadir}/gstreamer-1.0/presets/GstAmrnbEnc.prs"
FILES:${PN}-x264 += "${datadir}/gstreamer-1.0/presets/GstX264Enc.prs"
