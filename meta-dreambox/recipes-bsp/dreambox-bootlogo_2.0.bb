SUMMARY = "Bootlogo support"
LICENSE = "CLOSED"

SRCREV = "b680994da2cc9771fb07bae0032126612ba4caf7"
SRC_URI += " \
        file://showiframe-backdrop.service \
        file://bootlogo.scr \
"

inherit allarch opendreambox-github

SYSTEMD_SERVICE:${PN} = "showiframe-backdrop.service"
GITHUB_PROJECT = "bootlogo"

do_configure() {
}

do_install:append() {
	oe_runmake 'DESTDIR=${D}' install
    install -d ${D}${systemd_system_unitdir}
    install -m644 ${WORKDIR}/showiframe-backdrop.service ${D}${systemd_system_unitdir}
}

do_install:append:meson64() {
    install -d ${D}${sysconfdir}/u-boot.scr.d
    install -m 0644 ${WORKDIR}/bootlogo.scr ${D}${sysconfdir}/u-boot.scr.d
}

PACKAGES =+ "${PN}-u-boot"

FILES:${PN}-u-boot = "/boot/bootlogo.bmp ${sysconfdir}/u-boot.scr.d"

RDEPENDS:${PN} = "showiframe"

RRECOMMENDS:${PN}:append:meson64 = " ${PN}-u-boot"

pkg_postinst:${PN}-u-boot() {
[ -n "$D" ] || update-autoexec
}

INSANE_SKIP:${PN} = "installed-vs-shipped"
