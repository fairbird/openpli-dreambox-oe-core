FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "436c131d4c6534f123772e93c0326ce929f970ab"

SRC_URI:append = " file://restore-fmt-header-files.patch"

PV = "10.0.pre1"
PKGV = "10.0.pre1"
