KERNELVERSION = "4.9.113"

KERNEL_DEVICETREE = "${MACHINE}.dtb"

SOC_FAMILY = "meson64"
TARGET_ARCH = "aarch64"
DEFAULTTUNE = "aarch64"
require conf/machine/include/arm/arch-armv8a.inc
require conf/machine/include/soc-family.inc

SERIAL_CONSOLES = "1000000;ttyS0"

PREFERRED_PROVIDER_virtual/egl ?= "meson-mali"
PREFERRED_PROVIDER_virtual/libgles2 ?= "meson-mali"
PREFERRED_PROVIDER_virtual/libgl ?= "mesa-gl"
PREFERRED_PROVIDER_virtual/mesa ?= "mesa-gl"
PREFERRED_PROVIDER_virtual/blindscan-dvbs = "dreambox-blindscan-utils"
PREFERRED_PROVIDER_virtual/blindscan-dvbc = "dreambox-blindscan-utils"
PREFERRED_PROVIDER_virtual/kernel = "linux-dmamlogic"
PREFERRED_VERSION_linux-dmamlogic = "${KERNELVERSION}"
PREFERRED_PROVIDER_jpeg ?= "libjpeg-turbo"
PREFERRED_PROVIDER_jpeg-native ?= "libjpeg-turbo-native"

UBOOT_ENTRYPOINT = "0x1080000"

KERNEL_CLASSES = "kernel-fitimage"
KERNEL_IMAGETYPE = "Image.gz"

MACHINE_FEATURES = "dreambox hdmicec serial usbconsole usbgadget usbhost vfat ext2 rtc alsa screen blindscan-dvbc recovery bluetooth ci HDMI nogamma"

BOX_BRAND = "dreambox"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	alsa-plugins \
	alsa-plugins-pulseaudio-conf \
	bcmdhd \
	dm-precompiled \
	dreambox-dvb-modules-${MACHINE} \
	firmware-bcmdhd \
	flash-scripts \
	gstreamer1.0-dreamsinks \
	kernel-modules \
	meson-mali \
	meson-mali-module-bifrost-r12p0 \
	nrf52-firmware-${MACHINE} \
	u-boot-bin \
	"

KERNEL_MODULE_AUTOLOAD += "\
	mali_kbase \
	dhd \
	stb-core \
	meson64 \
	fp-dev \
	bluetooth \
	ble \
	videograbber \
	dreamframeinject \
	dreambox_rc2 \
	lcd \
	encoder \
	amvdec_avs \
	amvdec_avs2 \
	amvdec_h264 \
	amvdec_h264mvc \
	amvdec_h265 \
	amvdec_mh264 \
	amvdec_mjpeg \
	amvdec_mmjpeg \
	amvdec_mmpeg4 \
	amvdec_mpeg12 \
	amvdec_mpeg4 \
	amvdec_ports \
	amvdec_real \
	amvdec_vc1 \
	amvdec_vp9 \
	"

STB_PLATFORM = "dmamlogic"

RCNAME = "dmm2"

EXTRA_ALSA = "${STB_PLATFORM}"

MACHINE_FEATURES_BACKFILL_CONSIDERED += "rtc gobject-introspection-data"

DVBMEDIASINK_CONFIG = "--with-pcm --with-wma --with-wmv --with-dtsdownmix --with-eac3 --with-dts --with-vb6 --with-vb8 --with-spark --with-h265"

IMAGE_FSTYPES =+ "tar.xz"

IMAGE_CMD_tar_prepend = "\
	mkdir -p ${IMAGE_ROOTFS}/tmp; \
	rm -Rf ${IMAGE_ROOTFS}/tmp/*; \
	rm -f ${DEPLOY_DIR_IMAGE}/*.tar.xz; \
	"

MTD_ROOTFS = "mmcblk0p7"
MTD_KERNEL = "mmcblk0p6"
KERNEL_FILE = "kernel.bin"
ROOTFS_FILE = "rootfs.tar.xz"
MTD_BLACK  = "mmcblk0"

IMAGE_CLASSES += "tarxz-dreambox"
