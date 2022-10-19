SUMMARY = "WiFi devices for Realtek RTL8723a chipsets."
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
    rt8723a \
    firmware-rtl8723a \
"

PV = "1.0"
PR = "r0"

ALLOW_EMPTY:${PN} = "1"
