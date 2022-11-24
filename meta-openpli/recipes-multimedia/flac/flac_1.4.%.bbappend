FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://cast-to-float-prior-to-multiplying.patch"
