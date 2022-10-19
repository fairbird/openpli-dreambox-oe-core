SUMMARY = "ASIX AX8817X based USB 2.0 Ethernet Devices"
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
    kernel-module-usbnet \
    kernel-module-asix \
    "

PV = "1.0"
PR = "r0"

ALLOW_EMPTY:${PN} = "1"
