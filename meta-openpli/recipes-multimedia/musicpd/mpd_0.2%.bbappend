FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:remove = "boost"

inherit gitpkgv

SRC_URI = "git://github.com/MusicPlayerDaemon/MPD;branch=master;protocol=https \
			file://mpd.conf.in \
			file://mpd.init \
			file://fix-build-fmt-10-2-pre3.patch \
"

SRCREV = "823d6c9c0f68ba56ef995d83f3084d4a386f04b1"

PV = "0.23.14+git"
PKGV = "0.23.14+git${GITPKGV}"

do_install:append() {
	install -d ${D}${localstatedir}/lib/mpd/playlists
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${UNPACKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
}
