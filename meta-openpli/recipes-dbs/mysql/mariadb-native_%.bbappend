FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://fix-build-fmt-10-2-pre3.patch"

do_compile[network] = "1"
