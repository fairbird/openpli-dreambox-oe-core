FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:remove = "file://ffmpeg-6.0.patch"

CFLAGS += "-Wno-error=incompatible-pointer-types"

PV = "1.26.1"

SRC_URI[sha256sum] = "350a20b45b6655b6e10265430bdfbb3c436a96e9611b79caabef8f10abe570ea"
