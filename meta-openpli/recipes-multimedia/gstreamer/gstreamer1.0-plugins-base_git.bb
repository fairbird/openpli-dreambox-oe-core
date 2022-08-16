LICENSE = "GPL-2.0-only & LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=69333daa044cb77e486cc36129f7a770"

require gstreamer1.0-plugins.inc
require gstreamer1.0-common.inc

DEPENDS += "util-linux iso-codes zlib"

SRC_URI = " git://github.com/GStreamer/gst-plugins-base.git;protocol=https;branch=master \
			file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
			file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"

PACKAGES_DYNAMIC =+ "^libgst.*"

PACKAGECONFIG ??= "alsa ogg opus pango theora vorbis"

PACKAGECONFIG[alsa]			= "-Dalsa=enabled,-Dalsa=disabled,alsa-lib"
PACKAGECONFIG[ogg]			= "-Dogg=enabled,-Dogg=disabled,libogg"
PACKAGECONFIG[opus]			= "-Dopus=enabled,-Dopus=disabled,libopus"
PACKAGECONFIG[pango]		= "-Dpango=enabled,-Dpango=disabled,pango"
PACKAGECONFIG[theora]		= "-Dtheora=enabled,-Dtheora=disabled,libtheora"
PACKAGECONFIG[vorbis]		= "-Dvorbis=enabled,-Dvorbis=disabled,libvorbis"
   
FILES:${MLPREFIX}libgsttag-1.0 += "${datadir}/gst-plugins-base/1.0/license-translations.dict"
