DESCRIPTION = "A template for writing your own GStreamer plug-in"
MAINTAINER = "samsamsam"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base"

require conf/license/openpli-gplv2.inc
inherit gitpkgv autotools pkgconfig

PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/OpenVisionE2/gst-ifdsrc.git;protocol=https;branch=master"

S = "${WORKDIR}/git/gst-ifdsrc/gst-ifdsrc"

FILES:${PN} += "${libdir}/gstreamer-1.0"
