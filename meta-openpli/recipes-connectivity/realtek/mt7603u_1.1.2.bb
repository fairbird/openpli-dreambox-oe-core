SUMMARY = "mediatek 7603u v1.12"
HOMEPAGE = "www.mediatek.com"
SECTION = "kernel/modules"
LICENSE = "GPL-2.0-only"
require conf/license/license-gplv2.inc

inherit module

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/atvcaptain/mt7603u.git;protocol=https;branch=master"

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
                    -Wno-error \
                    -Wno-format \
                    -Wno-address \
                    -Wno-return-mismatch \
                    -Wno-format-extra-args \
                    -Wno-frame-larger-than \
                    -Wno-return-type \
                    -Wno-unused-variable \
                    -Wno-missing-attributes \
                    -Wno-address-of-packed-member \
                    -Wno-tautological-compare \
"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -m 0644 ${S}/os/linux/mt7603u_sta.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -d ${D}${sysconfdir}/Wireless/RT2870STA
    install -m 0644 ${S}/conf/MT7603USTA.dat ${D}${sysconfdir}/Wireless/RT2870STA/MT7603USTA.dat
}

FILES:${PN}:append = "${sysconfdir}/Wireless"


