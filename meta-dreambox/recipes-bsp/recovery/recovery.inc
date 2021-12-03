SUMMARY = "Command-line tools to flash and recover your Dreambox"
HOMEPAGE = "http://dreamboxupdate.com/"
LICENSE = "CLOSED"
DEPENDS = "coreutils-native udev"

PR = "r1"

inherit pkgconfig update-rc.d

do_install() {
    oe_runmake install DESTDIR=${D}
}

PACKAGES =+ "flash-scripts ${PN}-autoflashd ${PN}-fbscaled"

PACKAGE_ARCH = "${MACHINE_ARCH}"

EMMCRDEPENDS_recovery = " \
    e2fsprogs-mke2fs \
    gptfdisk \
"

EMMCRDEPENDS_flash-scripts = " \
    util-linux-sfdisk \
"

NANDRDEPENDS_recovery = " \
    mtd-utils-ubifs \
"

NANDRDEPENDS_flash-scripts = " \
    mtd-utils \
"

FASTBOOTRDEPENDS_flash-scripts = " \
    fastboot \
    mkbootblob \
"

RDEPENDS_${PN} = "\
    ${PN}-autoflashd \
    flash-scripts \
    gpgv \
    pigz \
    util-linux-blkid \
    util-linux-mount \
"

RDEPENDS_${PN}_append_dm820 = "\
    ${EMMCRDEPENDS_recovery} \
"

RDEPENDS_${PN}_append_dm7080 = "\
    ${EMMCRDEPENDS_recovery} \
"

RDEPENDS_${PN}_append_dm900 = "\
    ${EMMCRDEPENDS_recovery} \
"

RDEPENDS_${PN}_append_dm920 = "\
    ${EMMCRDEPENDS_recovery} \
"

RDEPENDS_${PN}_append_dm520 = "\
    ${NANDRDEPENDS_recovery} \
"

RDEPENDS_${PN}_append_dreamone = "\
    ${EMMCRDEPENDS_recovery} \
    ${PN}-fbscaled \
"

RDEPENDS_${PN}_append_dreamtwo = "\
    ${EMMCRDEPENDS_recovery} \
    ${PN}-fbscaled \
"

RDEPENDS_flash-scripts = "\
    coreutils-realpath \
"

RDEPENDS_flash-scripts_append_dm820 = "\
    ${EMMCRDEPENDS_flash-scripts} \
    ${FASTBOOTRDEPENDS_flash-scripts} \
"

RDEPENDS_flash-scripts_append_dm7080 = "\
    ${EMMCRDEPENDS_flash-scripts} \
    ${FASTBOOTRDEPENDS_flash-scripts} \
"

RDEPENDS_flash-scripts_append_dm900 = "\
    ${EMMCRDEPENDS_flash-scripts} \
"

RDEPENDS_flash-scripts_append_dm920 = "\
    ${EMMCRDEPENDS_flash-scripts} \
"

RDEPENDS_flash-scripts_append_dm520 = "\
    ${NANDRDEPENDS_flash-scripts} \
"

RDEPENDS_flash-scripts_append_dreamone = "\
    ${EMMCRDEPENDS_flash-scripts} \
    android-tools \
    u-boot-mkimage \
"

RDEPENDS_flash-scripts_append_dreamtwo = "\
    ${EMMCRDEPENDS_flash-scripts} \
    android-tools \
    u-boot-mkimage \
"

#RRECOMMENDS_flash-scripts = "dreambox-dvb-modules-stb-core"

FILES_${PN}-autoflashd = "\
    ${INIT_D_DIR}/autoflashd \
    ${sbindir}/autoflashd \
"

FILES_${PN}-fbscaled = "\
    ${INIT_D_DIR}/fbscaled \
    ${sbindir}/fbscaled \
"

FILES_flash-scripts = "\
    ${sbindir}/flash-fsbl \
    ${sbindir}/flash-rescue \
    ${sbindir}/flash-kernel \
    ${sbindir}/flash-ssbl \
    ${sbindir}/librecovery \
    ${sbindir}/readspi \
    ${sbindir}/select-boot-source \
    ${sbindir}/to-the-rescue \
    ${sbindir}/update-autoexec \
    ${sbindir}/update-rescue \
    ${sbindir}/writespi \
"

INITSCRIPT_PACKAGES = "${PN}-autoflashd ${PN}-fbscaled"
INITSCRIPT_NAME = ""
INITSCRIPT_NAME_${PN}-autoflashd = "autoflashd"
INITSCRIPT_NAME_${PN}-fbscaled = "fbscaled"
