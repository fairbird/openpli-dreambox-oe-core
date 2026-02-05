FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit upx-compress

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR .= ".1"

SRC_URI += "file://openssl-cnf.patch"

PV = "3.6.0"

SRC_URI[sha256sum] = "b6a5f44b7eb69e3fa35dbf15524405b44837a481d43d81daddde3ff21fcbb8e9"
