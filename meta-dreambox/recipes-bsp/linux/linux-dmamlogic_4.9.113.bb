DEPENDS = "libgcc"
PE = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(dreamone|dreamtwo)$"

DMPV = "643176-g72b0573"

MACHINE_KERNEL_PR = "${DMPV}-"

require linux-dreambox-dmamlogic.inc

SRC_URI = "https://dreamboxupdate.com/download/opendreambox/linux-meson64/linux-meson64-v${PV}-${DMPV}.tar.xz \
	file://kernel-add-support-for-gcc11.patch \
	file://kernel-add-support-for-gcc12.patch \
	file://defconfig \
	"

SRC_URI[md5sum] = "2b77df9bf64f825925172790c54f8ead"
SRC_URI[sha256sum] = "8d47072d819464d68b1b1072013795f925104dc09ad36e0bf9e0c7004087fed2"

KERNEL_CC += "${TOOLCHAIN_OPTIONS}"
KERNEL_LD += "${TOOLCHAIN_OPTIONS}"

S = "${WORKDIR}/linux-meson64-v${PV}-${DMPV}"

CMDLINE = "logo=osd0,loaded,0x7f800000 vout=2160p50hz,enable hdmimode=2160p50hz fb_width=1280 fb_height=720 ${@kernel_console(d)} root=/dev/mmcblk0p7 rootwait rootfstype=ext4 no_console_suspend"

# DEFCONFIG = "meson64"
UBOOT_MACHINE = "meson64"

LINUX_VERSION = "4.9"
KERNEL_IMAGETYPES = "Image.gz"

export KCFLAGS = "-Wno-error"

do_compile:append() {
    if test -n "${KERNEL_DEVICETREE}"; then
    	for DTB in ${KERNEL_DEVICETREE}; do
    		if echo ${DTB} | grep -q '/dts/'; then
    			bbwarn "${DTB} contains the full path to the the dts file, but only the dtb name should be used."
    			DTB=`basename ${DTB} | sed 's,\.dts$,.dtb,g'`
    		fi
    		oe_runmake ${DTB}
    	done
    	# Create directory, this is needed for out of tree builds
    	mkdir -p ${B}/arch/arm64/boot/dts/amlogic/
    	cp -f ${B}/arch/arm64/boot/dts/amlogic/${KERNEL_DEVICETREE} ${B}/arch/arm64/boot/
    fi
}

KERNEL_FLASH_ARGS = "-c '${CMDLINE}'"

do_rm_work() {
}
