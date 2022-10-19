SUMMARY = "WiFi devices for Atheros AR9170 devices."
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
    kernel-module-carl9170 \
    firmware-carl9170 \
    "

PV = "1.0"
PR = "r0"

ALLOW_EMPTY:${PN} = "1"
