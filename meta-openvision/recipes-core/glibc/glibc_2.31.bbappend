FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCREV_glibc = "3a44844c97a8ca1d0798c45b5252e6a49f9cf8e1"

SRC_URI += "\
			file://Ensure-array-index-is-within-size.patch \
"
