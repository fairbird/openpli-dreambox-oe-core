require gstreamer1.0-plugins-base.inc
include gstreamer1.0-common.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d"

SRC_URI = " git://anongit.freedesktop.org/gstreamer/gst-plugins-base;branch=master \
			file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
			file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"
