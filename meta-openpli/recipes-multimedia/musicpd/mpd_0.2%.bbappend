FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " fmt"
DEPENDS:remove = "boost"

inherit gitpkgv

SRC_URI = "git://github.com/MusicPlayerDaemon/MPD;branch=master;protocol=https \
           file://mpd.conf.in \
           file://mpd.init \
           file://fix-build-fmt-11-1-1.patch \
           "

SRCREV = "b1677bf79c437e6de937da9f82260a1d24ad6bd2"

PV = "0.23.16+git"
PKGV = "0.23.16+git${GITPKGV}"

do_install:append() {
	install -d ${D}${localstatedir}/lib/mpd/playlists
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${UNPACKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
}
