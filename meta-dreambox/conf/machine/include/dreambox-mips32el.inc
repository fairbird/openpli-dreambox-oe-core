# dreambox-mips32el.inc

BOX_BRAND = "dreambox"
KERNELVERSION = "3.2"

TARGET_ARCH = "mipsel"
DEFAULTTUNE = "mips32el"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	${@bb.utils.contains_any("MACHINE", "dm800se dm500hd", "dm-bootsplash", "", d)} \
	libpagecache \
	libpassthrough \
	"

MTD_KERNEL = "mtd2"

require conf/machine/include/dreambox.inc
require conf/machine/include/mips/tune-mips32.inc

DVBMEDIASINK_CONFIG = "--with-pcm --with-wma --with-wmv --with-dtsdownmix --with-eac3 --with-dts"
DVBMEDIASINK_CONFIG:dm8000 = "--with-pcm --with-wma --with-wmv --with-dtsdownmix --with-eac3 --with-dts --with-limited-mpeg4v2"
DVBMEDIASINK_CONFIG:dm7080 = "--with-pcm --with-wma --with-wmv --with-dtsdownmix --with-eac3 --with-dts --with-vb6 --with-vb8 --with-spark"
DVBMEDIASINK_CONFIG:dm820 = "--with-pcm --with-wma --with-wmv --with-dtsdownmix --with-eac3 --with-dts --with-vb6 --with-vb8 --with-spark"
DVBMEDIASINK_CONFIG:dm520 = "--with-pcm --with-wma --with-wmv --with-dtsdownmix --with-eac3 --with-dts --with-vb6 --with-vb8 --with-spark --with-h265"

CFLAGS:append:pn-titan = " -DDREAMBOX "

MACHINE_KERNEL_PR = "r14"
