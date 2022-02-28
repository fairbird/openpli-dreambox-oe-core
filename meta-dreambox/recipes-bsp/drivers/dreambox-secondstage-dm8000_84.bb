SUMMARY = "Dreambox second stage bootloader"
SECTION = "base"
LICENSE = "CLOSED"
PROVIDES += "virtual/bootloader"
PRIORITY = "required"
PACKAGE_ARCH = "${MACHINE_ARCH}"
DEPENDS = "dreambox-buildimage-native"
PR = "r20"

COMPATIBLE_MACHINE = "dm8000"

inherit deploy

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/secondstage-${MACHINE}-${PV}.bin"

SRC_URI[md5sum] = "8a6d83a266f88ec8fa5d130083f46d25"
SRC_URI[sha256sum] = "b5dbfe00674e8dea38b5069b1bfde3fe6b4486d4c4556ac775b3127e8454ca98"

PACKAGES = "${PN}"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/tmp
	buildimage --arch ${MACHINE} --raw ${EXTRA_BUILDCMD} \
	--erase-block-size ${DREAMBOX_ERASE_BLOCK_SIZE} \
	--flash-size ${DREAMBOX_FLASH_SIZE} \
	--sector-size ${DREAMBOX_SECTOR_SIZE} \
	--boot-partition=${DREAMBOX_PART0_SIZE}:secondstage-${MACHINE}-${PV}.bin \
	> ${D}/tmp/secondstage-${MACHINE}.bin
}

# busybox nandwrite requires oob patch and is not working in every box
RDEPENDS:${PN} = "mtd-utils"
FILES:${PN} = "/tmp/secondstage-${MACHINE}.bin"

pkg_postinst:${PN}() {
	if [ -z "$D" ] && grep -q '\<${MACHINE}\>' /proc/stb/info/model; then
		if [ -f /tmp/secondstage-${MACHINE}.bin ]; then
			flash_erase /dev/mtd1 0 0 2>/dev/null
			nandwrite -m -n -o /dev/mtd1 /tmp/secondstage-${MACHINE}.bin 2>/dev/null
			rm /tmp/secondstage-${MACHINE}.bin
		fi
	fi
}

do_deploy() {
	install -d ${DEPLOYDIR}
	install -m 0644 secondstage-${MACHINE}-${PV}.bin ${DEPLOYDIR}/secondstage-${MACHINE}.bin
}

addtask deploy before do_package after do_install
