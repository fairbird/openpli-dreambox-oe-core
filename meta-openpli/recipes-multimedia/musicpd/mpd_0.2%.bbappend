FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:remove = "boost"

inherit gitpkgv

SRC_URI:append = " file://mpd.init"
SRC_URI:remove = "file://0001-meson.build-support-building-with-ICU-76.patch"

SRCREV = "7774c3369e1484dc5dec6d7d9572e0a57e9c5302"

PV = "0.23.15+git"
PKGV = "0.23.15+git${GITPKGV}"

do_install:append() {
	install -d ${D}${localstatedir}/lib/mpd/playlists
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${UNPACKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
}
