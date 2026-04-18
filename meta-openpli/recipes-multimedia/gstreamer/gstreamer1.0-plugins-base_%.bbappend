FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"

SRC_URI:append = " \
		file://0002-subparse-set-need_segment-after-sink-pad-received-GS.patch \
		file://0003-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
		file://0004-add-missing-mesa-define.patch \
		file://0009-glimagesink-Downrank-to-marginal.patch \
"

LDFLAGS:append:mipsarch = " -latomic"

PACKAGECONFIG:append = " opus"

PACKAGECONFIG[gio] = "-Dgio=enabled,-Dgio=disabled,glib-2.0"

# files installed by both gstreamer1.0-plugins-base and kodi
do_install:append() {
        rm -f ${D}${includedir}/KHR/khrplatform.h
        rm -f ${D}${includedir}/GL/glext.h
}
