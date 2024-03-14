SUMMARY = "Open implementation of the DVB Common Scrambling Algorithm, encrypt and decrypt "
SECTION = "libs/multimedia"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRCREV = "2a1e61e569a621c55c2426f235f42c2398b7f18f"

SRC_URI = "git://github.com/glenvt18/libdvbcsa.git;branch=master;protocol=https \
           file://libdvbcsa.pc \
           file://streamrelay-libdvbcsa.patch \
"

S = "${WORKDIR}/git"

inherit autotools lib_package pkgconfig

EXTRA_OECONF = "\
	${@bb.utils.contains("TUNE_FEATURES", "neon aarch64", "--enable-neon", "", d)} \
"

do_install:append() {
    install -D -m 0644 ${S}/src/dvbcsa/dvbcsa.h ${D}${includedir}/dvbcsa/dvbcsa.h
    install -D -m 0644 ${WORKDIR}/libdvbcsa.pc ${D}${libdir}/pkgconfig/libdvbcsa.pc
}
