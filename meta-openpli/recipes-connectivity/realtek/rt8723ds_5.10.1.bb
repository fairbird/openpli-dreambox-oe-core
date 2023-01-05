SUMMARY = "Realtek 8723D SDIO or SPI WiFi"
HOMEPAGE = "https://www.realtek.com/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://ifcfg-wlan0;md5=a84acae65af4b2d44d5035aa9f63cd85"

DEPENDS ="bc-native"

SRC_URI = "git://github.com/edision-open/RTL8723DS_WiFi_linux.git;protocol=https"

SRCREV = "94eef3f7cb762b7309824be6cd2b6af75ac80bbd"

S = "${WORKDIR}/git"

inherit module

EXTRA_OEMAKE = 'KSRC="${STAGING_KERNEL_BUILDDIR}" USER_EXTRA_CFLAGS="-Wno-date-time" CONFIG_RTW_DEBUG=n'

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
    install -m 0644 ${S}/8723ds.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}
