SUMMARY = "Bootlogo support"
LICENSE = "CLOSED"

SRCREV = "a0bf37c5b20c1db4dc0008882cc5494b475be0c1"
SRC_URI += " \
        file://showiframe-backdrop.service \
        file://bootlogo.scr \
"

inherit allarch opendreambox-git

SYSTEMD_SERVICE:${PN} = "showiframe-backdrop.service"
OPENDREAMBOX_PROJECT = "bootlogo"

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
