FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:remove = "file://ffmpeg-6.0.patch"

CFLAGS += "-Wno-error=incompatible-pointer-types"

PV = "1.28.7"

SRC_URI[sha256sum] = "58da51dd39ecf1cf6faade34cc6412001be2e2e145bca8ae0f45336f60a36ab2"
