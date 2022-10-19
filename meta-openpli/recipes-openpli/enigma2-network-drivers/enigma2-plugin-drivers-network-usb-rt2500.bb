SUMMARY = "WiFi devices for Ralink RT2500USB/RT2571 devices."
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
    kernel-module-rt2500usb \
    "

PV = "1.0"
PR = "r0"

ALLOW_EMPTY:${PN} = "1"
