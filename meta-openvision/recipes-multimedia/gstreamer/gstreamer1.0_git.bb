require gstreamer1.0.inc
require gstreamer1.0-common.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d"

SRC_URI = " git://anongit.freedesktop.org/gstreamer/gstreamer;branch=master \
			file://001-revert-use-new-gst-adapter-get-buffer.patch \
"
