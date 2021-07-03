require gstreamer1.0-plugins.inc

LICENSE = "GPLv2+ & LGPLv2+ & LGPLv2.1+"

DEPENDS += "gstreamer1.0-plugins-base json-glib"

inherit gettext

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

ARM_INSTRUCTION_SET_armv4 = "arm"
ARM_INSTRUCTION_SET_armv5 = "arm"

FILES_${PN} +="${datadir}/gstreamer-${LIBV}/*"
FILES_${PN}-dev += "${libdir}/gstreamer-${LIBV}/include/gst/gl/gstglconfig.h"
FILES_${PN}-freeverb += "${datadir}/gstreamer-${LIBV}/presets/GstFreeverb.prs"
FILES_${PN}-opencv += "${datadir}/gst-plugins-bad/${LIBV}/opencv*"
FILES_${PN}-voamrwbenc += "${datadir}/gstreamer-${LIBV}/presets/GstVoAmrwbEnc.prs"
