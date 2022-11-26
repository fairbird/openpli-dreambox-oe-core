SUMMARY = "Hardware drivers for Dreambox"
SECTION = "base"
LICENSE = "CLOSED"
DEPENDS += "virtual/kernel dreambox-dvb-modules-systemd"
PRIORITY = "required"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PRECOMPILED_NAME = "dreambox-dvb-modules"

PRECOMPILED_ARCH = "${MACHINE}"

PACKAGES =+ "${PN}-firmware"

RDEPENDS:${PN}-firmware = "${PN}-firmware"
RDEPENDS:${PN} = "${PN}-firmware dreambox-dvb-modules-systemd"

FILES:${PN} = "${sysconfdir}/modules-load.d ${nonarch_base_libdir}/modules/${DM_LOCALVERSION}/extra"

FILES:${PN}-firmware = "${nonarch_base_libdir}/firmware"

# We don't use KERNEL_VERSION in this recipe, because the
# precompiled modules depend on a specific version.
DM_LOCALVERSION = "${@d.getVar('PV', True).rsplit('-', 1)[0]}"

pkg_postinst:${PN} () {
if [ -z "$D" ]; then
	depmod -a ${DM_LOCALVERSION}
fi
}

inherit opendreambox-precompiled-binary-new

RREPLACES:${PN} += "dreamframeinject"
RPROVIDES:${PN} += "dreamframeinject"
RCONFLICTS:${PN} += "dreamframeinject"
