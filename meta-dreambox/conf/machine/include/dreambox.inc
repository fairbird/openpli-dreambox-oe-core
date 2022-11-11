# dreambox.inc
# We know about rtc
MACHINE_FEATURES_BACKFILL_CONSIDERED += "rtc"

OPTIONAL_BSP_PACKAGES += "dreambox-buildimage"

EXTRA_IMAGEDEPENDS += "dreambox-secondstage-${MACHINE}"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "dreambox-dvb-modules-${MACHINE}"

MACHINE_EXTRA_RDEPENDS += "\
	gstreamer1.0-plugin-multibox-dvbmediasink \	
	ntfs-3g \
	kernel-module-cifs \
	kernel-module-hmac \
	kernel-module-md4 \
	${@bb.utils.contains("MACHINE", "dm800se dm500hhd dm8000 dm7020hd dm800sev2 dm500hdv2", "kernel-module-ecb", "", d)} \
	dreambox-boot-progress \
	"
	
MACHINE_FEATURES += "alsa usbhost dreambox"

PREFERRED_PROVIDER_virtual/bootloader = "dreambox-secondstage-${MACHINE}"
PREFERRED_PROVIDER_virtual/kernel = "linux-dreambox"
PREFERRED_PROVIDER_virtual/kodi = "stb-kodi-${MACHINE}"

PREFERRED_PROVIDER_virtual/blindscan-dvbs = "dreambox-blindscan-utils"
PREFERRED_PROVIDER_virtual/blindscan-dvbc = "dreambox-blindscan-utils"

KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "${KERNEL_IMAGETYPE}"
KERNEL_CONSOLE = "${@bb.utils.contains('OPENPLI_FEATURES', 'usbconsole', 'ttyS0,115200', 'null', d)}"

DREAMBOX_BUILDIMAGE = "buildimage --arch ${MACHINE} ${EXTRA_BUILDCMD} \
	--erase-block-size ${DREAMBOX_ERASE_BLOCK_SIZE} \
	--flash-size ${DREAMBOX_FLASH_SIZE} \
	--sector-size ${DREAMBOX_SECTOR_SIZE}"
