SUMMARY = "Open implementation of the AACS specification"
SECTION = "libs/multimedia"
LICENSE = "LGPL-2.1-only+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4b54a1fd55a448865a0b32d41598759d"
DEPENDS = "libgcrypt"
PV = "0.9.0+git"
PR = "r1"

SRC_URI = " git://code.videolan.org/videolan/${BPN}.git;protocol=https;branch=master \
			file://libgcrypt-gpg-error-use-pkgconfig.patch \
			"

S = "${WORKDIR}/git"

inherit autotools lib_package pkgconfig
