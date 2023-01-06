require linux-4.9.inc

do_configure:prepend() {
        sed -e "/^SUBLEVEL = /d" -i ${S}/Makefile
}

KERNEL_ENABLE_CGROUPS = "1"

# By default, kernel.bbclass modifies package names to allow multiple kernels
# to be installed in parallel. We revert this change and rprovide the versioned
# package names instead, to allow only one kernel to be installed.
PKG:${KERNEL_PACKAGE_NAME}-base = "kernel-base"
PKG:${KERNEL_PACKAGE_NAME}-image = "kernel-image"
RPROVIDES:${KERNEL_PACKAGE_NAME}-base = "kernel-${KERNEL_VERSION}"
RPROVIDES:${KERNEL_PACKAGE_NAME}-image = "kernel-image-${KERNEL_VERSION}"
RDEPENDS:${KERNEL_PACKAGE_NAME}-image = "kernel-devicetree flash-scripts"

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

pkg_postinst:${KERNEL_PACKAGE_NAME}-image () {
#!/bin/sh
[ -n "$D" ] || flash-kernel ${KERNEL_FLASH_ARGS} /boot/${KERNEL_IMAGETYPE}-${KERNEL_VERSION}
}

FILES:${KERNEL_PACKAGE_NAME}-image = "${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}*"

INITRAMFS_BASE_NAME = "rescue-${PV}-${PR}-${MACHINE}-${DATETIME}"

def kernel_console(d):
    console = ','.join(reversed(next(iter((d.getVar('SERIAL_CONSOLES') or '').split()), 'null').split(';')))
    return 'console=%s' % console
