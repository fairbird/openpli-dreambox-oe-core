FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " fmt"
DEPENDS:remove = "boost"

inherit gitpkgv

SRC_URI = "git://github.com/MusicPlayerDaemon/MPD;branch=master;protocol=https \
           file://mpd.conf.in \
           file://mpd.init \
           "

SRCREV = "1f7ffe1f73374b0bd1c82e9976e9c05b90dfeb29"

PV = "0.24.12+git"
PKGV = "0.24.12+git${GITPKGV}"

do_install:append() {
	install -d ${D}${localstatedir}/lib/mpd/playlists
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${UNPACKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
}
