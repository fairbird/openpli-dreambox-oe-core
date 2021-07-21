# dreambox-mips32el.inc

BOX_BRAND = "dreambox"
KERNELVERSION = "3.2"

TARGET_ARCH = "mipsel"
DEFAULTTUNE = "mips32el"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	libpagecache \
	libpassthrough \
	"

MTD_KERNEL = "mtd2"

require conf/machine/include/dreambox.inc
require conf/machine/include/tune-mips32.inc

MACHINE_KERNEL_PR = "r14"
