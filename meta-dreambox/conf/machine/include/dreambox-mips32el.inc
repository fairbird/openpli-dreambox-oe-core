# dreambox-mips32el.inc

STB_PLATFORM = "dm1gen"
BOX_BRAND = "dreambox"
KERNELVERSION = "3.2"

TARGET_ARCH = "mipsel"
DEFAULTTUNE = "mips32el"

MTD_KERNEL = "mtd2"

require conf/machine/include/dreambox.inc
require conf/machine/include/tune-mips32.inc

MACHINE_KERNEL_PR = "r14"
