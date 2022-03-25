LICENSE = "GPLv2+ & LGPLv2.1+"

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
		file://gst/replaygain/rganalysis.c;beginline=1;endline=23;md5=b60ebefd5b2f5a8e0cab6bfee391a5fe \
"

require gstreamer1.0-plugins.inc
require gstreamer1.0-common.inc

DEPENDS += "gstreamer1.0-plugins-base libcap orc zlib bzip2"

inherit gettext

SRC_URI = " git://github.com/GStreamer/gst-plugins-good.git;protocol=https \
		file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch \
"

PACKAGECONFIG ??= "cairo flac gdk-pixbuf jpeg lame mpg123 soup speex taglib vpx wavpack"

PACKAGECONFIG[cairo]		= "-Dcairo=enabled,-Dcairo=disabled,cairo"
PACKAGECONFIG[flac]			= "-Dflac=enabled,-Dflac=disabled,flac"
PACKAGECONFIG[gdk-pixbuf]	= "-Dgdk-pixbuf=enabled,-Dgdk-pixbuf=disabled,gdk-pixbuf"
PACKAGECONFIG[jpeg]			= "-Djpeg=enabled,-Djpeg=disabled,jpeg"
PACKAGECONFIG[lame]			= "-Dlame=enabled,-Dlame=disabled,lame"
PACKAGECONFIG[mpg123]		= "-Dmpg123=enabled,-Dmpeg123=disabled,mpg123"
PACKAGECONFIG[soup]			= "-Dsoup=enabled,-Dsoup=disabled,libsoup-2.4"
PACKAGECONFIG[speex]		= "-Dspeex=enabled,-Dspeex=disabled,speex"
PACKAGECONFIG[taglib]		= "-Dtaglib=enabled,-Dtaglib=disabled,taglib"
PACKAGECONFIG[vpx]			= "-Dvpx=enabled,-Dvpx=disabled,libvpx"
PACKAGECONFIG[wavpack]		= "-Dwavpack=enabled,-Dwavpack=disabled,wavpack"

FILES_${PN}-equalizer += "${datadir}/gstreamer-1.0/presets/*.prs"
