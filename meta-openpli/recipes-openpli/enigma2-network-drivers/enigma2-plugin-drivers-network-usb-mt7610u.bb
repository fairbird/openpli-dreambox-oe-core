SUMMARY = "mediatek 7610u"
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
     ${@bb.utils.contains("MACHINE_FEATURES", "linuxwifi", "", "mt7610u", d)} \
    "

PV = "1.0"
PR = "r0"

ALLOW_EMPTY:${PN} = "1"
