FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " fmt"
DEPENDS:remove = "boost"

inherit gitpkgv

SRC_URI = "git://github.com/MusicPlayerDaemon/MPD;branch=master;protocol=https \
           file://mpd.conf.in \
           file://mpd.init \
           "

SRCREV = "c426749d4709e8d4ec4a6808c004625fae37b60d"

PV = "0.24.6+git"
PKGV = "0.24.6+git${GITPKGV}"

do_install:append() {
	install -d ${D}${localstatedir}/lib/mpd/playlists
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${UNPACKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
}
