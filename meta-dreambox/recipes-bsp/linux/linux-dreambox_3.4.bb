inherit kernel machine_kernel_pr

INSANE_SKIP:${PN} += "already-stripped"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(dm520|dm820|dm7080)$"

PATCHREV = "30070c78a23d461935d9db0b6ce03afc70a10c51"
PATCHLEVEL = "113"

SRC_URI = " \
	${KERNELORG_MIRROR}/linux/kernel/v3.x/linux-${PV}.tar.xz;name=kernel \
	${KERNELORG_MIRROR}/linux/kernel/v3.x/patch-${PV}.${PATCHLEVEL}.xz;apply=yes;name=stable-patch \
	http://dreamboxupdate.com/download/kernel-patches/linux-dreambox-${PV}-${PATCHREV}.patch.xz;apply=yes;name=dream-patch \
	file://dvb_frontend-Multistream-support-${PV}.patch \
	file://genksyms_fix_typeof_handling.patch \
	file://defconfig \
	file://kernel-add-support-for-gcc11.patch \
	file://kernel-add-support-for-gcc12.patch \
	file://fix-never-be-null_outside-array-bounds-gcc-12.patch \
	file://0001-log2-give-up-on-gcc-constant-optimizations.patch \
	file://0002-cp1emu-do-not-use-bools-for-arithmetic.patch \
	file://0003-makefile-silence-packed-not-aligned-warn.patch \
	file://0004-fcrypt-fix-bitoperation-for-gcc.patch \
	"
	
SRC_URI[kernel.md5sum] = "967f72983655e2479f951195953e8480"
SRC_URI[kernel.sha256sum] = "ff3dee6a855873d12487a6f4070ec2f7996d073019171361c955639664baa0c6"
SRC_URI[stable-patch.md5sum] = "cbd978b714f37b648fbcf92482372223"
SRC_URI[stable-patch.sha256sum] = "d5492eeaadcf12aaad471011066e447907999035c26368da8e4f82b1871ef03a"
SRC_URI[dream-patch.md5sum] = "75844e4a206fd6ec3aeeaf1380c60b99"
SRC_URI[dream-patch.sha256sum] = "5ed3938ec088a868bcd344fd03adedbcefc5198c5255bd48f26fb87e1f8b7b07"

S = "${WORKDIR}/linux-${PV}"
B = "${WORKDIR}/build"

do_configure:prepend() {
        sed -e "/^SUBLEVEL = /d" -i ${S}/Makefile
}

require linux-dreambox_3.4.inc
require linux-extra-image.inc

CMDLINE_dm520 = "bmem=192M@64M console=ttyS0,1000000 ubi.mtd=rootfs root=ubi0:dreambox-rootfs rootfstype=ubifs rw"
CMDLINE_dm820 = "bmem=512M@512M memc1=768M console=ttyS0,1000000 root=/dev/mmcblk0p1 rootwait rootfstype=ext4"
CMDLINE_dm7080 = "bmem=512M@512M memc1=768M console=ttyS0,1000000 root=/dev/mmcblk0p1 rootwait rootfstype=ext4"

BRCM_PATCHLEVEL = "4.0"

LINUX_VERSION = "${PV}-${BRCM_PATCHLEVEL}-${MACHINE}"
KERNEL_IMAGETYPE_dm520 = "vmlinux.gz"
KERNEL_IMAGETYPE_dm820 = "vmlinux.bin"
KERNEL_IMAGETYPE_dm7080 = "vmlinux.bin"
KERNEL_IMAGETYPES_dm520 = ""
KERNEL_IMAGETYPES_dm820 = "vmlinux.gz"
KERNEL_IMAGETYPES_dm7080 = "vmlinux.gz"
KERNEL_ALT_IMAGETYPE_dm820 = "vmlinux.bin"
KERNEL_ALT_IMAGETYPE_dm7080 = "vmlinux.bin"

KERNEL_ENABLE_CGROUPS = "1"

RDEPENDS:${KERNEL_PACKAGE_NAME}-image = "flash-scripts"

pkg_postinst:kernel-image () {
#!/bin/sh
if [ -z "$D" ]; then
    flash-kernel /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${LINUX_VERSION}
fi
}

do_rm_work() {
}

# extra tasks
addtask kernel_link_images after do_compile before do_install
