require dreambox-secondstage-new.inc

COMPATIBLE_MACHINE = "^(dm520)$"

SRC_URI[dm520.md5sum] = "e1b388c62396e57b3c359fcc922eedad"
SRC_URI[dm520.sha256sum] = "d2253ab36ee0871206d019126e15750ae1eaefccf4cb11b6dca834d16f81c415"

MD5SUM = "${@d.getVarFlag('SRC_URI', 'dm520.md5sum', True)}"
