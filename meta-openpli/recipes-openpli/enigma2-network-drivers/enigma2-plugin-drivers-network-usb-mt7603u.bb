SUMMARY = "mediatek 7603u"
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
    mt7603u \
    "

PV = "1.0"
PR = "r0"

ALLOW_EMPTY:${PN} = "1"
