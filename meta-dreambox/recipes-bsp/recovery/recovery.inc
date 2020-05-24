SUMMARY = "Command-line tools to flash and recover your Dreambox"
HOMEPAGE = "http://dreamboxupdate.com/"
LICENSE = "CLOSED"
DEPENDS = "coreutils-native udev"

PR = "r1"

inherit pkgconfig update-rc.d

SRC_URI_append = ";branch=${BRANCH}"

do_install() {
    oe_runmake install DESTDIR=${D}
}

PACKAGES =+ "flash-scripts"

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = " \
    flash-scripts \
    gpgv \
    pigz \
    util-linux-mount \
    e2fsprogs-mke2fs \
    gptfdisk \
"

RDEPENDS_flash-scripts = " \
    coreutils-realpath \
    util-linux-sfdisk \
"

FILES_flash-scripts = " \
    ${sbindir}/flash-fsbl \
    ${sbindir}/flash-rescue \
    ${sbindir}/flash-kernel \
    ${sbindir}/flash-ssbl \
    ${sbindir}/librecovery \
    ${sbindir}/readspi \
    ${sbindir}/select-boot-source \
    ${sbindir}/to-the-rescue \
    ${sbindir}/update-rescue \
    ${sbindir}/writespi \
"

INITSCRIPT_NAME = "autoflashd"
