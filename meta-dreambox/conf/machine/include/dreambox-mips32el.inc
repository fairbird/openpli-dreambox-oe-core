# dreambox-mips32el.inc

TARGET_ARCH = "mipsel"
DEFAULTTUNE = "mips32el"

IMAGEDIR ?= "${MACHINE}"

require conf/machine/include/dreambox.inc
require conf/machine/include/mips/tune-mips32.inc

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    dreambox-dvb-modules-${MACHINE} \
    kernel-module-stv0299 \
    ${@bb.utils.contains("MACHINE", "dm800se dm500hd", "dm-bootsplash", "", d)} \
    libpagecache \
    libpassthrough \
    "
