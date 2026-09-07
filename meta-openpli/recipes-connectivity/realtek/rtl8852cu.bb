SUMMARY = "Realtek rtw8852cu"
HOMEPAGE = "http://www.realtek.com.tw"
SECTION = "kernel/modules"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b7e6779b3b112ee657a10f5a3e1a4beb"

inherit module

PR = "r1"
SRCREV = "${AUTOREV}"
# Use short destsuffix — the driver has ~370 object files whose absolute paths
# overflow ARG_MAX during kbuild linking on machines with long MACHINE names.
SRC_URI = "git://github.com/oe-alliance-drivers/rtl8852cu.git;protocol=https;branch=master;destsuffix=s"

# The default unpack directory "sources" costs six more characters on every
# object path, and this driver has several hundred of them.
UNPACKDIR = "${WORKDIR}/u"

S = "${UNPACKDIR}/s"

# WPA3-SAE; the driver leaves this path disabled unless we ask for it
EXTRA_OEMAKE = "KSRC=${STAGING_KERNEL_DIR} LINUX_SRC=${STAGING_KERNEL_DIR} KDIR=${STAGING_KERNEL_DIR} \
    USER_EXTRA_CFLAGS=-DCONFIG_KERNEL_PATCH_EXTERNAL_AUTH"

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
                    -Wno-error=incompatible-pointer-types \
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
    install -m 0644 ${S}/8852cu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}
