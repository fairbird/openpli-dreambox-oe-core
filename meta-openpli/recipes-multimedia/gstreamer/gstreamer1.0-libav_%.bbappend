FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:remove = "file://ffmpeg-6.0.patch"

CFLAGS += "-Wno-error=incompatible-pointer-types"

PV = "1.28.6"

SRC_URI[sha256sum] = "71e6eafb4fff2a66d1bb0ba8d078224dfe7e3397307d8c0bba3dc23606e08f51"
