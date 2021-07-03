FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS = "audiofile boost curl faad2 expat ffmpeg flac glib-2.0 icu libao libcdio libmikmod libogg libvorbis virtual/libiconv zlib"

SRC_URI += " \
			file://mpd.init \
			"

do_install_append() {
	install -d ${D}${localstatedir}/lib/mpd/playlists
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
}
