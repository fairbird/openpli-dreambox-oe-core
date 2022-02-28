require dreambox-secondstage-new.inc

COMPATIBLE_MACHINE = "^(dm820)$"

SRC_URI[dm820.md5sum] = "597f55dbc5b87133d305690db41c0c8e"
SRC_URI[dm820.sha256sum] = "26afa1d0922f95bedf3856b8ad7866453c2ffc1da2d2cee17b79f11fa077afe6"

MD5SUM = "${@d.getVarFlag('SRC_URI', 'dm820.md5sum', True)}"
