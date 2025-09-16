FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " fmt"
DEPENDS:remove = "boost"

inherit gitpkgv

SRC_URI = "git://github.com/MusicPlayerDaemon/MPD;branch=master;protocol=https \
           file://mpd.conf.in \
           file://mpd.init \
           "

SRCREV = "cc372873021c4a9a71e17890d89620476ef9e6bd"

PV = "0.24.5+git"
PKGV = "0.24.5+git${GITPKGV}"

do_install:append() {
	install -d ${D}${localstatedir}/lib/mpd/playlists
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${UNPACKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
}
