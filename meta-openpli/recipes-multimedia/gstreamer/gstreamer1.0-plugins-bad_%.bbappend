FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"

PV = "1.26.1"

SRC_URI[sha256sum] = "9b8415b1bb3726a499578fb39907952981716643f660215fe68628fbd8629197"

SRC_URI:append = " \
        file://0001-Revert-tsdemux-Limit-the-maximum-PES-payload-size.patch \
        file://0002-Revert-tsdemux-always-take-the-seek-segment-stop-int.patch \
        file://0004-rtmp-hls-tsdemux-fix.patch \
        file://0005-rtmp-fix-seeking-and-potential-segfault.patch \
        file://0006-dvbapi5-fix-old-kernel.patch \
        file://0007-hls-main-thread-block.patch \
"

SRC_URI:remove = "file://0001-uvcgadget-Use-g_path_get_basename-instead-of-libc-ba.patch \
		file://0001-backport-libatomic-issue-patch.patch \
"

PACKAGECONFIG:append = " faac faad opusparse rtmp"

EXTRA_OEMESON:remove = "-Dkate=disabled"

LDFLAGS:append:mipsarch = " -latomic"
