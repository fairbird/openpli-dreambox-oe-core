require linux-dmamlogic.inc

DEPENDS += "linux-firmware"

RDEPENDS_kernel-module-carl9170 ?= "linux-firmware-carl9170"
RDEPENDS_kernel-module-r8712u ?= "linux-firmware-rtl8192su"
RDEPENDS_kernel-module-rt2800usb ?= "linux-firmware-rt2800usb"
RDEPENDS_kernel-module-rt73usb ?= "linux-firmware-rt73usb"
RDEPENDS_kernel-module-zd1211rw ?= "zd1211-firmware"
RRECOMMENDS_kernel-module-cifs ?= "kernel-module-arc4 kernel-module-ecb kernel-module-hmac kernel-module-md4"
RRECOMMENDS_kernel-module-mac80211 ?= "kernel-module-aes-generic kernel-module-arc4"

KERNEL_ENABLE_CGROUPS = "1"

# By default, kernel.bbclass modifies package names to allow multiple kernels
# to be installed in parallel. We revert this change and rprovide the versioned
# package names instead, to allow only one kernel to be installed.
PKG_kernel = "kernel"
RPROVIDES_${KERNEL_PACKAGE_NAME} = "${KERNEL_PACKAGE_NAME}-${KERNEL_VERSION}"
PKG_${KERNEL_PACKAGE_NAME}-base = "${KERNEL_PACKAGE_NAME}-base"
RPROVIDES_${KERNEL_PACKAGE_NAME}-base = "${KERNEL_PACKAGE_NAME}-base-${KERNEL_VERSION}"
RDEPENDS_${KERNEL_PACKAGE_NAME}-base = ""
PACKAGES_remove = "${KERNEL_PACKAGE_NAME}-image"

KERNEL_FLASH_ARGS ?= ""

python __anonymous() {
    type = d.getVar('KERNEL_IMAGETYPE', True) or ""
    alttype = d.getVar('KERNEL_ALT_IMAGETYPE', True) or ""
    types = d.getVar('KERNEL_IMAGETYPES', True) or ""
    types = ('%s %s %s' % (type, types, alttype)).split()
    devicetree = d.getVar('KERNEL_DEVICETREE', False)

    for imagetype in set(types):
        d.setVar('PKG_kernel-image-%s' % imagetype.lower(), 'kernel-image-%s' % imagetype.lower())
        d.setVar('RPROVIDES_kernel-image-%s' % imagetype.lower(), 'kernel-image-%s-${KERNEL_VERSION}' % imagetype.lower())
        if devicetree:
            d.appendVar('RDEPENDS_kernel-image-%s' % imagetype.lower(), ' kernel-devicetree')

    imagetype = types[0]
    d.setVar('RDEPENDS_kernel-image', 'kernel-image-%s' % imagetype.lower())

    postinst = d.getVar('pkg_postinst_kernel-image-%s' % imagetype.lower(), False)
    if not postinst:
        postinst = '#!/bin/sh\n'
    postinst += '[ -n "$D" ] || flash-kernel ${KERNEL_FLASH_ARGS} /${KERNEL_IMAGEDEST}/%s-${KERNEL_VERSION_NAME}\n' % imagetype
    d.setVar('pkg_postinst_kernel-image-%s' % imagetype.lower(), postinst)

    d.setVar('PKG_kernel-image-%s' % imagetype.lower(), 'kernel-image')
    d.appendVar('RPROVIDES_kernel-image-%s' % imagetype.lower(), ' kernel-image-${KERNEL_VERSION}')
    d.setVar('RDEPENDS_kernel-base', 'kernel-image-%s' % imagetype.lower())
}

INITRAMFS_BASE_NAME = "rescue-${PV}-${PR}-${MACHINE}-${DATETIME}"

def kernel_console(d):
    console = ','.join(reversed(next(iter((d.getVar('SERIAL_CONSOLES') or '').split()), 'null').split(';')))
    return 'console=%s' % console
