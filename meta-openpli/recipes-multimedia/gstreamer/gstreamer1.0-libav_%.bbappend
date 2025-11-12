FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.8"
 
SRC_URI[sha256sum] = "d8610d88026cc4927eb013e46ecf505f73ee946ec8b8fd5aee5b3ae4614a5d59"

SRC_URI:remove = "file://ffmpeg-6.0.patch"

CFLAGS += "-Wno-error=incompatible-pointer-types"
