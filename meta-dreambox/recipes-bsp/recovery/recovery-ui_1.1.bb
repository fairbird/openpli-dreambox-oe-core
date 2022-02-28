SUMMARY = "Simple user interface for Dreambox rescue mode"
HOMEPAGE = "http://dreamboxupdate.com/"
LICENSE = "CLOSED"
DEPENDS = "libmnl xz"

SRCREV = "1cd69394b3702a06cadfce078289dd351a07b152"
SRCREV_dm820 = "${SRCREV_dm7080}"
SRCREV_dm7080 = "ed7dd69f2d24c040b2a4ebfbeeb63135132abde7"
SRCREV_dreamone = "${SRCREV_dm7080}"
SRCREV_dreamtwo = "${SRCREV_dm7080}"

inherit opendreambox-git pkgconfig update-rc.d

do_install() {
	oe_runmake install DESTDIR=${D}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

RRECOMMENDS:${PN} = "dreambox-dvb-modules-${MACHINE}-lcd"

DMBRANCH_dm7080 = "dm7080"
DMBRANCH_dm820 = "dm7080"
DMBRANCH_dreamone = "dm7080"
DMBRANCH_dreamtwo = "dm7080"

COMPATIBLE_MACHINE = "^(dm820|dm7080|dreamone|dreamtwo)$"

INITSCRIPT_NAME = "${BPN}"
