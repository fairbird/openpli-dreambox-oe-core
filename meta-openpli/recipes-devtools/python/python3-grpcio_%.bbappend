FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

include python3-package-split.inc

SRC_URI += "file://openssl40-compat.patch"
