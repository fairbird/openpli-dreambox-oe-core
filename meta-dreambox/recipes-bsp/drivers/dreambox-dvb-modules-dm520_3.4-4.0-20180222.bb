KV = "${KERNELVERSION}-4.0"
DRIVERDATE = "20180222"

require dreambox-dvb-modules-new.inc

SRC_URI[dm520.md5sum] = "7d1f171a31a8affe4fa940aeafbaf2bc"
SRC_URI[dm520.sha256sum] = "64dc5646079c61561313cb3e89d1577f4212d8aa1fc7b28fa9f42247459b0305"

COMPATIBLE_MACHINE = "^(dm520)$"

MD5SUM = "${@d.getVarFlag('SRC_URI', 'dm520.md5sum', True)}"
