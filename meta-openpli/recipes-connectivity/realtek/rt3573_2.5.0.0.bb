SUMMARY = "Ralink 3573 v2.5.0.0"
HOMEPAGE = "http://www.realtek.com.tw"
SECTION = "kernel/modules"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://iwpriv_usage.txt;md5=8876ae2c103446a442658f1cc2a01b76"


inherit module

SRC_URI = "https://source.mynonpublic.com/ini/20120911_RT3573_Linux_STA_v2.5.0.0_Rev4_DPO.tar.gz \
    file://remove_linux_2_4_compability.patch"

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
"

S = "${WORKDIR}/20120911_RT3573_Linux_STA_v2.5.0.0_Rev4_DPO"

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -m 0644 ${S}/os/linux/rt3573sta.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -d ${D}/etc/Wireless/RT3573STA
    install -m 0644 ${S}/RT2870STA.dat ${D}/etc/Wireless/RT3573STA/RT3573STA.dat
    install -m 0644 ${S}/RT2870STACard.dat ${D}/etc/Wireless/RT3573STA/RT3573STACard.dat
}

SRC_URI[md5sum] = "08256c9b2ae77308b608662dc0ba3a1b"
SRC_URI[sha256sum] = "d3422502e09020bd6909aa63be87747604de976a312c3d38c811b6cf6ac84fe9"

FILES:${PN}:append = "${sysconfdir}/Wireless"


