FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
PR .= ".3"

PACKAGE_ARCH := "${MACHINE_ARCH}"

RDEPENDS:${PN}:append = " util-linux-flock"

SRC_URI += " \
    file://67_init_hddown.dpatch \
    file://92_sata-hddown.dpatch \
"

do_install:append() {
    rm ${D}${sysconfdir}/rc*.d/*bootlogd
}
