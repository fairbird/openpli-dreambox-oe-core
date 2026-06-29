FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:remove = "file://ffmpeg-6.0.patch"

CFLAGS += "-Wno-error=incompatible-pointer-types"

PV = "1.28.4"
 
SRC_URI[sha256sum] = "bd17a5df2874a7a58bcbaf7b940223379ad9613624db8ead783db03e74bb904b"
