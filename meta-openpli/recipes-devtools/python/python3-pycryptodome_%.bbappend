include ${PYTHON_PN}-package-split.inc

PROVIDES += "${PYTHON_PN}-pycrypto"
RPROVIDES:${PN} += "${PYTHON_PN}-pycrypto"
RCONFLICTS:${PN} = "${PYTHON_PN}-pycrypto"
RREPLACES:${PN} = "${PYTHON_PN}-pycrypto"
