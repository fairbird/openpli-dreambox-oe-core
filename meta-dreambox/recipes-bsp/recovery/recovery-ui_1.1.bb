SUMMARY = "Simple user interface for Dreambox rescue mode"
HOMEPAGE = "http://dreamboxupdate.com/"
LICENSE = "CLOSED"
DEPENDS = "libmnl xz"

SRCREV = "1cd69394b3702a06cadfce078289dd351a07b152"
SRCREV:dm820 = "${SRCREV:dm7080}"
SRCREV:dm7080 = "ed7dd69f2d24c040b2a4ebfbeeb63135132abde7"
SRCREV:dreamone = "${SRCREV:dm7080}"
SRCREV:dreamtwo = "${SRCREV:dm7080}"

inherit opendreambox-git pkgconfig update-rc.d

do_install() {
	oe_runmake install DESTDIR=${D}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

#RRECOMMENDS:${PN} = "dreambox-dvb-modules-${MACHINE}-lcd"

DMBRANCH:dm7080 = "dm7080"
DMBRANCH:dm820 = "dm7080"
DMBRANCH:dreamone = "dm7080"
DMBRANCH:dreamtwo = "dm7080"

COMPATIBLE_MACHINE = "^(dm820|dm7080|dreamone|dreamtwo)$"

INITSCRIPT_NAME = "${BPN}"
