FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit upx-compress

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI += "file://openssl-cnf.patch"

PV = "3.6.2"

SRC_URI[sha256sum] = "aaf51a1fe064384f811daeaeb4ec4dce7340ec8bd893027eee676af31e83a04f"
