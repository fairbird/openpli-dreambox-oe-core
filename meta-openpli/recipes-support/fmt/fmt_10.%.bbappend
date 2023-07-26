FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "3dec65b7fd8df55bd5904a1e22dd907038634cf0"

SRC_URI:append = " file://restore-fmt-header-files.patch"

PV = "10.0.pre1"
PKGV = "10.0.pre1"
