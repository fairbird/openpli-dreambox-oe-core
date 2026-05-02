FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit upx-compress

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI += "file://openssl-cnf.patch"

SRC_URI:remove = "file://0001-Added-handshake-history-reporting-when-test-fails.patch"

PV = "4.0.0"

SRC_URI[sha256sum] = "c32cf49a959c4f345f9606982dd36e7d28f7c58b19c2e25d75624d2b3d2f79ac"
