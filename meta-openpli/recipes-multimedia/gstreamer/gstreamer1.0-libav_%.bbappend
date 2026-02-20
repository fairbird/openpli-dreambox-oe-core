FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.0"

SRC_URI[sha256sum] = "e3c93db7da2da3b2374ccc2e7394316f9192460abdea81651652791d46ccb8fb"

SRC_URI:remove = "file://ffmpeg-6.0.patch"

CFLAGS += "-Wno-error=incompatible-pointer-types"
