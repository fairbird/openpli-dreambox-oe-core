FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"

PV = "1.26.7"

SRC_URI[sha256sum] = "a0ab17dddd4c029ecd7a423c30badd5a3c7599ea42707016d1d57545f5723ccf"

SRC_URI:append = " \
        file://0001-Revert-tsdemux-Limit-the-maximum-PES-payload-size.patch \
        file://0002-Revert-tsdemux-always-take-the-seek-segment-stop-int.patch \
        file://0004-rtmp-hls-tsdemux-fix.patch \
        file://0005-rtmp-fix-seeking-and-potential-segfault.patch \
        file://0006-dvbapi5-fix-old-kernel.patch \
        file://0007-hls-main-thread-block.patch \
        file://0008-gsthlsaudiometa.patch \
"

SRC_URI:remove = "file://0001-uvcgadget-Use-g_path_get_basename-instead-of-libc-ba.patch"

PACKAGECONFIG:append = " faac faad opusparse rtmp"

EXTRA_OEMESON:remove = "-Dkate=disabled"

LDFLAGS:append:mipsarch = " -latomic"
