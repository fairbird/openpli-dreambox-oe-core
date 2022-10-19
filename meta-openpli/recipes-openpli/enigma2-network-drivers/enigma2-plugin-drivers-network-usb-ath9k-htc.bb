SUMMARY = "WiFi devices for for Atheros AR9001 and AR9002 devices."
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
    kernel-module-ath9k-htc \
    firmware-htc7010 \
    firmware-htc9271 \
    "

PV = "1.0"
PR = "r0"

ALLOW_EMPTY:${PN} = "1"
