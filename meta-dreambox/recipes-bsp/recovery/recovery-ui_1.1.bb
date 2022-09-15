SUMMARY = "Simple user interface for Dreambox rescue mode"
HOMEPAGE = "http://dreamboxupdate.com/"
LICENSE = "CLOSED"
DEPENDS = "libmnl xz"
SRCREV = "1cd69394b3702a06cadfce078289dd351a07b152"
SRCREV:dm820 = "${SRCREV:dm7080}"
SRCREV:dm7080 = "650568ea2f64fb86e40bcfec82de05d1c4e9226b"
SRCREV:dreamone = "${SRCREV:dm7080}"
SRCREV:dreamtwo = "${SRCREV:dm7080}"

SRC_URI:append = ";branch=${BRANCH}"

inherit opendreambox-git pkgconfig update-rc.d

do_install() {
    oe_runmake install DESTDIR=${D}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = "dreambox-dvb-modules-${MACHINE}-lcd"

BRANCH = "master"
BRANCH:dm820 = "dm7080"
BRANCH:dm7080 = "dm7080"
DMBRANCH:dreamone = "dm7080"
DMBRANCH:dreamtwo = "dm7080"

COMPATIBLE_MACHINE = "^(dm820|dm7080|dreamone|dreamtwo)$"

INITSCRIPT_NAME = "${BPN}"
