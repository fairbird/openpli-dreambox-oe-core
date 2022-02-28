LICENSE = "CLOSED"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = " file://${CURRENT_FW}"

RPROVIDES:${PN} += "nrf52-firmware"

do_compile() {
}

do_install() {
	install -d ${D}${datadir}/nrf52-firmware
	install -m 644 ${S}/../${CURRENT_FW} ${D}${datadir}/nrf52-firmware
}

FILES:${PN} = "${datadir}/nrf52-firmware"
