FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
                file://0001-Fix-build-with-fmt-post-9.1.patch \
"

