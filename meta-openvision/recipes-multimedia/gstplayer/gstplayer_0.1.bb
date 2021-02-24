DESCRIPTION = "gstplayer by samsamsam"
SECTION = "multimedia"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base"

inherit pkgconfig

SRC_URI = "	git://gitlab.com/e2i/gstplayer.git;protocol=http \
			file://0001-set-iptv-download-timeout-0-to-disable-ifdsrc.patch \
			file://0002-rename-stored-sink-to-dvbSink-for-clarity.patch \
			file://0003-try-to-get-PTS-from-video-sink-first.patch \
			file://0004-increase-eos-fix-timeout-to-10s.patch \
"

S = "${WORKDIR}/git"

do_compile() {
	cd ${S}/gst-1.0
	${CC} *.c ../common/*.c -I../common/ `pkg-config --cflags --libs gstreamer-1.0 gstreamer-pbutils-1.0` -o gstplayer_gst-1.0 ${LDFLAGS}
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/gst-1.0/gstplayer_gst-1.0 ${D}${bindir}/gstplayer
}

pkg_postinst_${PN}() {
	ln -sf gstplayer $D${bindir}/gstplayer_gst-1.0
}

pkg_prerm_${PN}() {
	rm -f $D${bindir}/gstplayer_gst-1.0
}
