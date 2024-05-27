FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"
SRC_URI:append = " \
        file://0001-Revert-tsdemux-Limit-the-maximum-PES-payload-size.patch \
        file://0002-Revert-tsdemux-always-take-the-seek-segment-stop-int.patch \
        file://0003-Revert-tsdemux-Use-gst_segment_do_seek.patch \
        file://0004-rtmp-hls-tsdemux-fix.patch \
        file://0005-rtmp-fix-seeking-and-potential-segfault.patch \
        file://0006-dvbapi5-fix-old-kernel.patch \
        file://0007-hls-main-thread-block.patch \
"

SRC_URI:remove = "file://0004-opencv-resolve-missing-opencv-data-dir-in-yocto-buil.patch"

PACKAGECONFIG:append = " \
    assrender faac faad libde265 neon opusparse resindvd rtmp \
"

PACKAGECONFIG:remove = "rsvg"

EXTRA_OEMESON:remove = "-Dkate=disabled"

PV = "1.24.3"

SRC_URI[md5sum] = "4371fd500cc142be875c0ca7b24398cf"
SRC_URI[sha256sum] = "e90f26c7dc9c76f4aa599b758cfd6d8c10d6a0b9cb265ba2c3c9bdf3888558f8"
