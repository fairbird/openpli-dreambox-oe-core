LICENSE = "GPL-2.0-only & LGPL-2.0-only & LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

require gstreamer1.0-plugins.inc
require gstreamer1.0-common.inc

DEPENDS += "gstreamer1.0-plugins-base json-glib"

inherit gettext

SRC_URI = " git://github.com/GStreamer/gst-plugins-bad.git;protocol=https;branch=master \
			file://001-rtmp-hls-tsdemux-fix.patch \
			file://002-fix-maybe-uninitialized-warnings-when-compiling-with-Os.patch \
			file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"

EXTRA_OECONF += " \
	--disable-openjpeg \
	"

PACKAGECONFIG ??= "bz2 curl dash dtls faac faad hlsdl libmms rsvg rtmp sbc smoothstreaming sndfile uvch264 webp"

PACKAGECONFIG[bz2]				= "-Dbz2=enabled,-Dbz2=disabled,bzip2"
PACKAGECONFIG[curl]				= "-Dcurl=enabled,-Dcurl=disabled,curl"
PACKAGECONFIG[dash]				= "-Ddash=enabled,-Ddash=disabled,libxml2"
PACKAGECONFIG[dtls]				= "-Ddtls=enabled,-Ddtls=disabled,openssl"
PACKAGECONFIG[faac]				= "-Dfaac=enabled,-Dfaac=disabled,faac"
PACKAGECONFIG[faad]				= "-Dfaad=enabled,-Dfaad=disabled,faad2"
PACKAGECONFIG[hlsdl]			= "-Dhls=enabled,-Dhls=disabled,openssl"
PACKAGECONFIG[libmms]			= "-Dlibmms=enabled,-Dlibmms=disabled,libmms"
PACKAGECONFIG[rsvg]				= "-Drsvg=enabled,-Drsvg=disabled,librsvg"
PACKAGECONFIG[rtmp]				= "-Drtmp=enabled,-Drtmp=disabled,rtmpdump"
PACKAGECONFIG[sbc]				= "-Dsbc=enabled,-Dsbc=disabled,sbc"
PACKAGECONFIG[smoothstreaming]	= "-Dsmoothstreaming=enabled,-Dsmoothstreaming=disabled,libxml2"
PACKAGECONFIG[sndfile]			= "-Dsndfile=enabled,-Dsndfile=disabled,libsndfile1"
PACKAGECONFIG[uvch264]			= "-Duvch264=enabled,-Duvch264=disabled,libusb1 libgudev"
PACKAGECONFIG[webp]				= "-Dwebp=enabled,-Dwebp=disabled,libwebp"

export OPENCV_PREFIX = "${STAGING_DIR_TARGET}${prefix}"

ARM_INSTRUCTION_SET:armv4 = "arm"
ARM_INSTRUCTION_SET:armv5 = "arm"

FILES:${PN} +="${datadir}/gstreamer-${LIBV}/*"
FILES:${PN}-dev += "${libdir}/gstreamer-${LIBV}/include/gst/gl/gstglconfig.h"
FILES:${PN}-freeverb += "${datadir}/gstreamer-${LIBV}/presets/GstFreeverb.prs"
FILES:${PN}-opencv += "${datadir}/gst-plugins-bad/${LIBV}/opencv*"
FILES:${PN}-voamrwbenc += "${datadir}/gstreamer-${LIBV}/presets/GstVoAmrwbEnc.prs"
