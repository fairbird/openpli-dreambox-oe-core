FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit upx-compress

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI += "file://openssl-cnf.patch"

PV = "3.6.1"

SRC_URI[sha256sum] = "b1bfedcd5b289ff22aee87c9d600f515767ebf45f77168cb6d64f231f518a82e"
