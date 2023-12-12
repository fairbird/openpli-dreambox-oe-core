FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:remove = "boost"

inherit gitpkgv

SRC_URI = "git://github.com/MusicPlayerDaemon/MPD;branch=master;protocol=https \
			file://mpd.conf.in \
			file://mpd.init \
"

SRCREV = "a6024f476a83423a9a30f0a25b57955e204773b3"

PV = "0.23.14+git"
PKGV = "0.23.14+git${GITPKGV}"

do_install:append() {
	install -d ${D}${localstatedir}/lib/mpd/playlists
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
}
