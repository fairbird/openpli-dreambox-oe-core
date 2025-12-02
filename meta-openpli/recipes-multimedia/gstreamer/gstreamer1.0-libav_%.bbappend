FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.9"
 
SRC_URI[sha256sum] = "08a8e944fc61ef26df515784a089c8ac41765304a5d55b98199835b28a98dbdf"

SRC_URI:remove = "file://ffmpeg-6.0.patch"

CFLAGS += "-Wno-error=incompatible-pointer-types"
