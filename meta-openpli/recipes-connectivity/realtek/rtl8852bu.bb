SUMMARY = "Realtek RTL8832BU and RTL8852BU"
HOMEPAGE = "http://www.realtek.com.tw"
SECTION = "kernel/modules"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1918d7d89f091725a3188ff95f7c72b"

inherit module

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRCREV = "${AUTOREV}"
# Use short destsuffix - the driver has ~370 object files whose absolute paths
# overflow ARG_MAX during kbuild linking on machines with long MACHINE names.
SRC_URI = "git://github.com/atvcaptain/rtl8852bu-wpa3.git;protocol=https;branch=main;destsuffix=s"

S = "${UNPACKDIR}/s"

# WPA3-SAE; the driver leaves this path disabled unless we ask for it
EXTRA_OEMAKE = "KSRC=${STAGING_KERNEL_DIR} USER_EXTRA_CFLAGS=-DCONFIG_KERNEL_PATCH_EXTERNAL_AUTH"

# need only for dreambox linux-meson64 4.9 + GCC 15
export KCFLAGS += " -std=gnu17 \
                    -Wno-error=misleading-indentation \
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

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -m 0644 ${S}/8852bu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}
