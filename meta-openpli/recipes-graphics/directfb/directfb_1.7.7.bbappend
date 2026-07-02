BBCLASSEXTEND = "native"
PACKAGE_ARCH := "${MACHINE_ARCH}"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"

INSANE_SKIP += "32bit-time"
TARGET_CFLAGS += "-Wa,--noexecstack"
