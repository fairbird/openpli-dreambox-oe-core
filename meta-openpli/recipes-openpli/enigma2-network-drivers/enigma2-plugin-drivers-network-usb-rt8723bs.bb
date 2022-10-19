SUMMARY = "WiFi devices for Realtek 8723bs chipsets."
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = "\
    rt8723bs \
"

PV = "1.0"
PR = "r2"

ALLOW_EMPTY:${PN} = "1"
