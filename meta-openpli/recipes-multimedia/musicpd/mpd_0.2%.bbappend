FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://mpd.init \
	file://use-structure-member-data.patch \
"

do_install:append() {
	install -d ${D}${localstatedir}/lib/mpd/playlists
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
}
