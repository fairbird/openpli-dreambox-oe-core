SUMMARY = "WiFi devices for Realtek 88x1CU chipsets."
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
        rt8821cu \
        linux-firmware-8821cu \
"

PV = "1.0"
PR = "r2"

ALLOW_EMPTY:${PN} = "1"
