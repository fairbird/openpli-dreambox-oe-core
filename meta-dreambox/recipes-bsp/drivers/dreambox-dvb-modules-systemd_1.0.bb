SUMMARY = "Hardware drivers for Dreambox - udev rules for systemd"
LICENSE = "CLOSED"

SRC_URI = "file://${BPN}.rules"

S = "${WORKDIR}"

inherit allarch

do_install() {
    install -d ${D}${base_libdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/${BPN}.rules ${D}${base_libdir}/udev/rules.d/10-${BPN}.rules
}
