SUMMARY = "WiFi devices for Realtek 8192FU chipsets."
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
    rtl8192fu \
    "

PV = "1.0"
PR = "r0"

ALLOW_EMPTY:${PN} = "1"
