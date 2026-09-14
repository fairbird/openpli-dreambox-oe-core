FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"

PV = "1.28.7"

SRC_URI[sha256sum] = "ed6e5410f496d171818763af2265e7977154bc7f9b827e98acf8c5bed21dd5a7"

SRC_URI:append = " \
		file://0002-subparse-set-need_segment-after-sink-pad-received-GS.patch \
		file://0003-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
		file://0004-add-missing-mesa-define.patch \
		file://0009-glimagesink-Downrank-to-marginal.patch \
"

PACKAGECONFIG:append = " \
    cdparanoia gio opus tremor \
"

LDFLAGS:append:mipsarch = " -latomic"

CFLAGS:append = "${@' -mthumb' if d.getVar('TARGET_ARCH') == 'arm' else ''}"

PACKAGECONFIG[gio] = "-Dgio=enabled,-Dgio=disabled,glib-2.0"

# files installed by both gstreamer1.0-plugins-base and kodi
do_install:append() {
        rm -f ${D}${includedir}/KHR/khrplatform.h
        rm -f ${D}${includedir}/GL/glext.h
}

INSANE_SKIP:libgstgl-1.0 += "file-rdeps"
