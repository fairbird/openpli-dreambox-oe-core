DESCRIPTION = "A cross platform audio library"
LICENSE = "GPL"
HOMEPAGE = "http://www.xiph.org/ao/"
SECTION = "libs/multimedia"
DEPENDS = "alsa-lib"
PROVIDES = "libao-alsa libao-alsa-plugin"
PR = "r1"

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "git://github.com/oe-mirrors/libao.git;protocol=https;branch=master"

inherit autotools pkgconfig

EXTRA_OECONF = "\
  --disable-esd \
  --disable-esdtest \
  --disable-alsa \
  --enable-alsa09 \
  --disable-arts \
  --disable-nas \
  --disable-pulse \
"

PACKAGES =+ "${PN}-alsa ${PN}-alsa-dev ${PN}-pulse ${PN}-pulse-dev ${PN}-oss ${PN}-oss-dev"

FILES:${PN}-alsa = "${libdir}/ao/plugins-2/libalsa*.so"
FILES:${PN}-alsa-dev = "${libdir}/ao/plugins-2/libalsa*.la"
FILES:${PN}-pulse = "${libdir}/ao/plugins-2/libpulse*.so"
FILES:${PN}-pulse-dev = "${libdir}/ao/plugins-2/libpulse*.la"
FILES:${PN}-oss = "${libdir}/ao/plugins-2/liboss*.so"
FILES:${PN}-oss-dev = "${libdir}/ao/plugins-2/liboss*.la"

FILES:${PN} += "${libdir}/ao/plugins-2/*.so"
FILES:${PN}-dev += "${libdir}/ao/plugins-2/*.la"
FILES:${PN}-dbg += "${libdir}/ao/plugins-2/.debug"

SRC_URI[md5sum] = "b92cba3cbcf1ee9bc221118a85d23dcd"
SRC_URI[sha256sum] = "e52e05af6b10f42d2ee9845df1a581bf2b352060eabf7946aee0a600c3878954"
