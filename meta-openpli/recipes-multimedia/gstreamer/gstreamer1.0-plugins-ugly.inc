require gstreamer1.0-plugins.inc

LICENSE = "GPLv2+ & LGPLv2.1+ & LGPLv2+"
LICENSE_FLAGS = "commercial"

DEPENDS += "gstreamer1.0-plugins-base"

inherit gettext

PACKAGECONFIG ??= "a52dec amrnb amrwbdec cdio dvdread mpeg2dec orc x264"

PACKAGECONFIG[amrnb]	= "-Damrnb=enabled,-Damrnb=false,opencore-amr"
PACKAGECONFIG[amrwbdec]	= "-Damrwbdec=enabled,-Damrwbdec=false,opencore-amr"
PACKAGECONFIG[a52dec]	= "-Da52dec=enabled,-Dlibwacom=false,liba52"
PACKAGECONFIG[cdio]		= "-Dcdio=enabled,-Dcdio=disabled,libcdio"
PACKAGECONFIG[dvdread]	= "-Ddvdread=enabled,-Ddvdread=disabled,libdvdread"
PACKAGECONFIG[mpeg2dec]	= "-Dmpeg2dec=enabled,-Dmpeg2dec=disabled,mpeg2dec"
PACKAGECONFIG[orc]		= "-Dorc=enabled,-Dorc=disabled,orc"
PACKAGECONFIG[x264]		= "-Dx264=enabled,-Dx264=disabled,x264"

FILES_${PN}-amrnb += "${datadir}/gstreamer-1.0/presets/GstAmrnbEnc.prs"
FILES_${PN}-x264 += "${datadir}/gstreamer-1.0/presets/GstX264Enc.prs"
