FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:remove = "boost"

inherit gitpkgv

SRC_URI:append = " file://mpd.init"
SRC_URI:remove = "file://0001-meson.build-support-building-with-ICU-76.patch"

SRCREV = "b1677bf79c437e6de937da9f82260a1d24ad6bd2"

PV = "0.23.16+git"
PKGV = "0.23.16+git${GITPKGV}"

do_install:append() {
	install -d ${D}${localstatedir}/lib/mpd/playlists
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${UNPACKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
}
