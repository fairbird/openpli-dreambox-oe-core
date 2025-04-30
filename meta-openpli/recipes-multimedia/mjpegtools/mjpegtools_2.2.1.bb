SUMMARY = "MJPEG video capture/editting/playback MPEG encoding"
HOMEPAGE = "http://sourceforge.net/projects/mjpeg/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS = "jpeg libpng"
RDEPENDS:${PN} = "bash"

SRC_URI = "https://sourceforge.net/projects/mjpeg/files/mjpegtools/${PV}/${BP}.tar.gz \
           file://fix-build-with-gcc15.patch \
"

SRC_URI[md5sum] = "168e0131c0b8a2e31df7a73eb602fc32"
SRC_URI[sha256sum] = "b180536d7d9960b05e0023a197b00dcb100929a49aab71d19d55f4a1b210f49a"

inherit autotools pkgconfig

EXTRA_OECONF = " \
        --without-libquicktime \
        --without-libdv \
        --without-dga \
        --without-gtk \
        --without-libsdl \
        --without-v4l \
        --without-x \
"
