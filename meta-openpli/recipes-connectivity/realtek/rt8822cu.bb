SUMMARY = "Ralink 8822CU/8812CU"
HOMEPAGE = "http://www.realtek.com.tw"
SECTION = "kernel/modules"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://ifcfg-wlan0;md5=6061d24ec65e191716f64bb3fe580790"

DEPENDS ="bc-native"

inherit module
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/atvcaptain/RTL8822C.git;protocol=https;branch=main \
"

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR} KDIR=${STAGING_KERNEL_DIR}"

# need only for dreambox linux-meson64 4.9 + GCC 14
export KCFLAGS += " -Wno-error=misleading-indentation \
                    -Wno-error=aggressive-loop-optimizations \
                    -Wno-error=int-to-pointer-cast \
                    -Wno-error=restrict \
                    -Wno-error=int-conversion \
                    -Wno-error=maybe-uninitialized \
                    -Wno-error=discarded-qualifiers \
                    -Wno-error=switch-unreachable \
                    -Wno-error=bool-operation \
                    -Wno-error=declaration-after-statement \
                    -Wno-error=implicit-function-declaration \
                    -Wno-error=incompatible-pointer-types \
                    -Wno-error=ignored-qualifiers \
                    -Wno-error  \
                    -Wno-format \
                    -Wno-address \
                    -Wno-return-mismatch \
                    -Wno-format-extra-args \
                    -Wno-frame-larger-than \
                    -Wno-return-type \
                    -Wno-unused-variable \
                    -Wno-missing-attributes \
                    -Wno-address-of-packed-member \
"

S = "${WORKDIR}/git"

do_compile () {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS CC LD CPP
    oe_runmake 'M={D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless' \
        'KERNEL_SOURCE=${STAGING_KERNEL_DIR}' \
        'LINUX_SRC=${STAGING_KERNEL_DIR}' \
        'KDIR=${STAGING_KERNEL_DIR}' \
        'KERNDIR=${STAGING_KERNEL_DIR}' \
        'KSRC=${STAGING_KERNEL_DIR}' \
        'KERNEL_VERSION=${KERNEL_VERSION}' \
        'KVER=${KERNEL_VERSION}' \
        'CC=${KERNEL_CC}' \
        'AR=${KERNEL_AR}' \
        'LD=${KERNEL_LD}'
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -m 0644 ${S}/88x2cu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless

}


