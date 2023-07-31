SUMMARY = "Broadcom DHD driver"
LICENSE = "GPL-2.0-only"
require conf/license/license-gplv2.inc

DEPENDS = "virtual/kernel"
RDEPENDS:${PN} = "firmware-bcmdhd"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit module-base machine_kernel_pr

SRC_URI = "https://source.mynonpublic.com/dreambox/${BPN}.${PV}-${SRCREV}.tar.xz \
           file://0001-Makefile-set-default-firmware-path.patch"
SRC_URI[md5sum] = "6c4425868dd86785f1986ce7642685f1"
SRC_URI[sha256sum] = "177af925bc2e7130e59dc56b0e6f13b992fee8ab57e7b221671e5cb2ec37e008"

S = "${WORKDIR}/${BPN}.${PV}"

M ?= "${S}"

EXTRA_OEMAKE += "\
    ARCH=${ARCH} \
    CONFIG_BCMDHD_SDIO=y \
    CROSS_COMPILE=${TARGET_PREFIX} \
    DEPMOD=echo \
    INSTALL_MOD_PATH=${D} \
    KDIR=${STAGING_KERNEL_DIR} \
    M=${M} \
"

do_compile() {
    unset CC CFLAGS CPP CPPFLAGS CXX CXXFLAGS CCLD LDFLAGS
    oe_runmake -C ${STAGING_KERNEL_DIR} modules
}

do_install() {
    unset CC CFLAGS CPP CPPFLAGS CXX CXXFLAGS CCLD LDFLAGS
    oe_runmake -C ${STAGING_KERNEL_DIR} modules_install

    install -d ${D}${sysconfdir}/modules-load.d
    echo dhd > ${D}${sysconfdir}/modules-load.d/00-${BPN}.conf
    chmod 0644 ${D}${sysconfdir}/modules-load.d/00-${BPN}.conf
}

FILES:${PN} = "${sysconfdir}/modules-load.d \
               ${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra"

pkg_postinst:${PN} () {
if [ -z "$D" ]; then
	depmod -a ${KERNEL_VERSION}
fi
}

export KCFLAGS = " \
	-Wno-error=stringop-overflow \
	-Wno-error=address \
	-Wno-error=address-of-packed-member \
	-Wno-error=missing-attributes \
	"

addtask do_prepare_recipe_sysroot before do_compile
