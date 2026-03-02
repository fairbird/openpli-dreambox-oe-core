FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.1"

SRC_URI[sha256sum] = "bfa91aaca38d0fd8addcdd559e35b7541e3f32a5f410194ec4ba18040defee9b"

SRC_URI:remove = "file://ffmpeg-6.0.patch"

CFLAGS += "-Wno-error=incompatible-pointer-types"
