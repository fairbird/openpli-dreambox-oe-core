SUMMARY = "Realtek RTL8192EU USB wireless driver"
HOMEPAGE = "http://www.realtek.com/"
SECTION = "kernel/modules"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://README.md;md5=cab676681a0415e7c5d9a42fd47514df"

inherit module

PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/atvcaptain/rtl8192eu-5.11.2.3.git;protocol=https;branch=5.11.2.3 \
           file://0001-add-strscpy-compat-for-kernels-before-4.3.patch \
"

EXTRA_OEMAKE = "KSRC=${STAGING_KERNEL_DIR}"

# WPA3-SAE, through KCFLAGS because this Makefile has no USER_EXTRA_CFLAGS hook
KCFLAGS:append = " -DCONFIG_KERNEL_PATCH_EXTERNAL_AUTH"

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
    install -m 0644 ${S}/8192eu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}
