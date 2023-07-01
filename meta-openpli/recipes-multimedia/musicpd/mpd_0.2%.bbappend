FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:remove = "boost"

SRC_URI = "git://github.com/MusicPlayerDaemon/MPD;branch=master;protocol=https \
	file://mpd.conf.in \
	file://mpd.init \
"

SRCREV = "9c19368fc789fa7101110f73b6ffae8503ae326d"

PV = "0.23.14"
PKGV = "0.23.14"

do_install:append() {
	install -d ${D}${localstatedir}/lib/mpd/playlists
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
}
