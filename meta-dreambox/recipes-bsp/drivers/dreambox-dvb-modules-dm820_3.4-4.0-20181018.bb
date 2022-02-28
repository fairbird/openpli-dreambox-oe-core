KV = "${KERNELVERSION}-4.0"
DRIVERDATE = "20181018"

require dreambox-dvb-modules-new.inc

SRC_URI[dm820.md5sum] = "f219ccdae57db1d2602fa57abe3f80cc"
SRC_URI[dm820.sha256sum] = "52261e5f574226a88d9528151ec60952ddb9d1f401824729897cba82c7ba0cd7"

COMPATIBLE_MACHINE = "^(dm820)$"

MD5SUM = "${@d.getVarFlag('SRC_URI', 'dm820.md5sum', True)}"
