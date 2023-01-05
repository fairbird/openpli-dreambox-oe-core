SUMMARY = "driver for Realtek USB wireless devices"
SECTION = "kernel/modules"
LICENSE = "GPL-2.0-only"

LIC_FILES_CHKSUM = "file://hal/hal_init.c;beginline=1;endline=19;md5=f8d10a6bd2fdfa240c0634a7c660c57f"

RREPLACES:${PN} = "kernel-module-rtl8192cu"


inherit module

SRC_URI = "http://downloads.pli-images.org/misc/rtl8188C_8192C_8192D_usb_linux_v3.3.0_2971.20111128.tar.gz \
    file://additional_productids.patch \
    file://rtl8192cu-gcc5.patch \
    "

S = "${WORKDIR}/rtl8188C_8192C_8192D_usb_linux_v3.3.0_2971.20111128"

inherit module

EXTRA_OEMAKE = "KSRC=${STAGING_KERNEL_DIR} KDIR=${STAGING_KERNEL_DIR}"

# need only for dreambox linux-meson64 4.9
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
                    -Wno-error=incompatible-pointer-types \
                    -Wno-error \
"

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -m 0644 ${S}/8192cu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}

SRC_URI[md5sum] = "6d5bd5f94d9d6d6667393839c1861101"
SRC_URI[sha256sum] = "fab0db3ee9fa60beff5ca18248e0ed20bf439873f94461c47e0deda28d184b2b"


