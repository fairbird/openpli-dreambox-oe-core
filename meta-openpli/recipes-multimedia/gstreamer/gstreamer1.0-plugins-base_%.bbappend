FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"

PV = "1.28.3"
 
SRC_URI[sha256sum] = "27880f3d87efa3bb5aa5f99f7ef6e4be7c95229f44eee928c1633d32e87d0099"

SRC_URI:append = " \
		file://0002-subparse-set-need_segment-after-sink-pad-received-GS.patch \
		file://0003-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
		file://0004-add-missing-mesa-define.patch \
		file://0009-glimagesink-Downrank-to-marginal.patch \
"

LDFLAGS:append:mipsarch = " -latomic"

CFLAGS:append = "${@' -mthumb' if d.getVar('TARGET_ARCH') == 'arm' else ''}"

PACKAGECONFIG:append = " opus"

PACKAGECONFIG[gio] = "-Dgio=enabled,-Dgio=disabled,glib-2.0"

# files installed by both gstreamer1.0-plugins-base and kodi
do_install:append() {
        rm -f ${D}${includedir}/KHR/khrplatform.h
        rm -f ${D}${includedir}/GL/glext.h
}
