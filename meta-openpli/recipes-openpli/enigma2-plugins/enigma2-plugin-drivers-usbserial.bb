DESCRIPTION = "USB serial drivers"

require conf/license/openpli-gplv2.inc

RDEPENDS:${PN} = " \	
	${@bb.utils.contains("MACHINE", "dreamone dreamtwo", "", "kernel-module-belkin-sa", d)} \
	kernel-module-usbserial \
	kernel-module-ftdi-sio \
	kernel-module-pl2303 \
	kernel-module-keyspan \
	"

PV = "1.0"

ALLOW_EMPTY:${PN} = "1"
