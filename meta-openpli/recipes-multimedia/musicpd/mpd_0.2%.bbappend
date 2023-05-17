FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:remove = "boost"

SRC_URI = "git://github.com/MusicPlayerDaemon/MPD;branch=master;protocol=https \
	file://mpd.conf.in \
	file://mpd.init \
"

SRCREV = "c69b9780df4b69fe4f22231916df8083aa92a647"

PV = "0.23.pre13"
PKGV = "0.23.pre13"

do_install:append() {
	install -d ${D}${localstatedir}/lib/mpd/playlists
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
}
