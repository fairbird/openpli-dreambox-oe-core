FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:remove = "file://ffmpeg-6.0.patch"

CFLAGS += "-Wno-error=incompatible-pointer-types"

PV = "1.28.3"
 
SRC_URI[sha256sum] = "28fcd45d9ace261d4bda896466d5326af6efd2fcf0a20f24502094b5a9955bdf"
