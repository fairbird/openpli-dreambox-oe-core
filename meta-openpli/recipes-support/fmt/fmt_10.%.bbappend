FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "757564f5cd2fa78b634dd698c63dbf069818e6fd"

SRC_URI:append = " file://restore-fmt-header-files.patch"

PV = "10.0.pre1"
PKGV = "10.0.pre1"
