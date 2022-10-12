SUMMARY = "mediatek 7601u"
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS:${PN} = " \
    ${@bb.utils.contains("LINUX_WIFI_mt7106u", "kernel-module-mt7601u", "kernel-module-mt7601u", "mt7601u", d)} \
    firmware-mt7601u \
    "

PV = "1.0"
PR = "r2"

ALLOW_EMPTY:${PN} = "1"

do_populate_sysroot[noexec] = "1"
do_package_qa[noexec] = "1"
