SUMMARY = "mediatek 7610u"
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
     mt7610u \
    "

PV = "1.0"
PR = "r0"

ALLOW_EMPTY:${PN} = "1"

do_populate_sysroot[noexec] = "1"
do_package_qa[noexec] = "1"
