SUMMARY = "WiFi devices based on Ralink 802.11n USB chipsets."
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
    kernel-module-rt2800usb \
    firmware-rt2870 \
    "

PV = "1.0"
PR = "r0"

ALLOW_EMPTY:${PN} = "1"
