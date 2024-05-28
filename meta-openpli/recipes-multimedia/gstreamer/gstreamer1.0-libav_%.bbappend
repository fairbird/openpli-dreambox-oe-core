FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://port-read-probe-to-ffinputformat.patch"

SRC_URI:remove = "file://ffmpeg-6.0.patch"

CFLAGS += "-Wno-error=incompatible-pointer-types"

PV = "1.24.3"

SRC_URI[md5sum] = "f53b4ad32a6d3fc0c34117cde310d962"
SRC_URI[sha256sum] = "d9c5b152468a45c1fa8351410422090a7192707ad74d2e1a4367f5254e188d91"
