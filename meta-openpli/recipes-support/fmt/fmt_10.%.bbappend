FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "606f85f8b23bd342988ab82ce7da52343c916396"

SRC_URI:append = " file://restore-fmt-header-files.patch"

PV = "10.0.pre1"
PKGV = "10.0.pre1"
