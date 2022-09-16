SUMMARY = "Command-line tools to flash and recover your Dreambox"
HOMEPAGE = "http://dreamboxupdate.com/"
LICENSE = "CLOSED"
DEPENDS = "coreutils-native udev"

inherit pkgconfig update-rc.d

do_install() {
	oe_runmake install DESTDIR=${D}
}

PACKAGES =+ "flash-scripts ${PN}-autoflashd ${PN}-fbscaled"

PACKAGE_ARCH = "${MACHINE_ARCH}"

EMMCRDEPENDS:recovery = "\
	e2fsprogs-mke2fs \
	gptfdisk \
	"

EMMCRDEPENDS:flash-scripts += "util-linux-sfdisk"

NANDRDEPENDS:recovery += "mtd-utils-ubifs"

NANDRDEPENDS:flash-scripts += "mtd-utils"

FASTBOOTRDEPENDS:flash-scripts = "\
	fastboot \
	mkbootblob \
	"

RDEPENDS:${PN} = "\
	${PN}-autoflashd \
	flash-scripts \
	gpgv \
	pigz \
	util-linux-blkid \
	util-linux-mount \
	"

RDEPENDS:${PN}:append:dm820 = " ${EMMCRDEPENDS:recovery}"
RDEPENDS:${PN}:append:dm7080 = " ${EMMCRDEPENDS:recovery}"
RDEPENDS:${PN}:append:dm900 = " ${EMMCRDEPENDS:recovery}"
RDEPENDS:${PN}:append:dm920 = " ${EMMCRDEPENDS:recovery}"
RDEPENDS:${PN}:append:dm520 = " ${NANDRDEPENDS:recovery}"

RDEPENDS:${PN}:append:dreamone = "\
	${EMMCRDEPENDS:recovery} \
	${PN}-fbscaled \
	"

RDEPENDS:${PN}:append:dreamtwo = "\
	${EMMCRDEPENDS:recovery} \
	${PN}-fbscaled \
	"

RDEPENDS:flash-scripts += "coreutils-realpath"

RDEPENDS:flash-scripts:append:dm820 = "\
	${EMMCRDEPENDS:flash-scripts} \
	${FASTBOOTRDEPENDS:flash-scripts} \
	"

RDEPENDS:flash-scripts:append:dm7080 = "\
	${EMMCRDEPENDS:flash-scripts} \
	${FASTBOOTRDEPENDS:flash-scripts} \
	"

RDEPENDS:flash-scripts:append:dm900 = " ${EMMCRDEPENDS:flash-scripts}"
RDEPENDS:flash-scripts:append:dm920 = " ${EMMCRDEPENDS:flash-scripts}"
RDEPENDS:flash-scripts:append:dm520 = " ${NANDRDEPENDS:flash-scripts}"

RDEPENDS:flash-scripts:append:dreamone = "\
	${EMMCRDEPENDS:flash-scripts} \
	android-tools \
	u-boot-mkimage \
	"

RDEPENDS:flash-scripts:append:dreamtwo = "\
	${EMMCRDEPENDS:flash-scripts} \
	android-tools \
	u-boot-mkimage \
	"

#RRECOMMENDS:flash-scripts = "dreambox-dvb-modules-stb-core"

FILES:${PN}-autoflashd = "\
	${INIT_D_DIR}/autoflashd \
	${sbindir}/autoflashd \
	"

FILES:${PN}-fbscaled = "\
	${INIT_D_DIR}/fbscaled \
	${sbindir}/fbscaled \
	"

FILES:flash-scripts = "\
	${sbindir}/flash-fsbl \
	${sbindir}/flash-kernel \
	${sbindir}/flash-rescue \
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
INITSCRIPT_NAME:${PN}-autoflashd = "autoflashd"
INITSCRIPT_NAME:${PN}-fbscaled = "fbscaled"
