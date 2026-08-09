FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"

PV = "1.28.6"

SRC_URI[sha256sum] = "6636f2c2289ceda52c4aba971338c81e2b5780d3381bd3673c1c116ec87587c3"

SRC_URI:append = " \
        file://0001-Revert-tsdemux-Limit-the-maximum-PES-payload-size.patch \
        file://0002-Revert-tsdemux-always-take-the-seek-segment-stop-int.patch \
        file://0004-rtmp-hls-tsdemux-fix.patch \
        file://0005-rtmp-fix-seeking-and-potential-segfault.patch \
        file://0006-dvbapi5-fix-old-kernel.patch \
        file://0007-hls-main-thread-block.patch \
        file://0008-gsthlsaudiometa.patch \
        file://0009-tsdemux-cc-recovery-hls.patch \
"

SRC_URI:remove = "file://0001-uvcgadget-Use-g_path_get_basename-instead-of-libc-ba.patch"

PACKAGECONFIG:remove = "rsvg openssl"

PACKAGECONFIG:append = " \
	assrender faac faad libde265 neon nettle opusparse resindvd rtmp srt \
"

EXTRA_OEMESON:remove = "-Dkate=disabled"

LDFLAGS:append:mipsarch = " -latomic"
