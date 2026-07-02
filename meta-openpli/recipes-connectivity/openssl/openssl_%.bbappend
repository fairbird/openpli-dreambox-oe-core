FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit upx-compress

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI += "file://openssl-cnf.patch"

SRC_URI:remove = "file://0001-Added-handshake-history-reporting-when-test-fails.patch"

PV = "4.0.1"

SRC_URI[sha256sum] = "2db3f3a0d6ea4b59e1f094ace2c8cd536dffb87cdc39084c5afa1e6f7f37dd09"
