require dreambox-secondstage-new.inc

COMPATIBLE_MACHINE = "^(dm7080)$"

SRC_URI[dm7080.md5sum] = "ef12410e7944e23cffaa6753531d7bdd"
SRC_URI[dm7080.sha256sum] = "c50354e66d6f247ab533a518b9df42c2067f6711cd210f9e25983233018df016"

MD5SUM = "${@d.getVarFlag('SRC_URI', 'dm7080.md5sum', True)}"
