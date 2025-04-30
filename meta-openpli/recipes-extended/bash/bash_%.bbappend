FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://mkbuiltins-for-gcc-15.patch"

inherit upx-compress
