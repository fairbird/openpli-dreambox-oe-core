FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://0001-Fix-build-against-glibc-2.43.patch;striplevel=2"
