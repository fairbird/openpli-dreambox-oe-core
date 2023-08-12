FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:remove = "boost"

SRC_URI = "git://github.com/MusicPlayerDaemon/MPD;branch=master;protocol=https \
	file://mpd.conf.in \
	file://mpd.init \
"

SRCREV = "ba2df05fb439d11acf2a35287555ec7816aab6a7"

PV = "0.23.14"
PKGV = "0.23.14"

do_install:append() {
	install -d ${D}${localstatedir}/lib/mpd/playlists
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
}
