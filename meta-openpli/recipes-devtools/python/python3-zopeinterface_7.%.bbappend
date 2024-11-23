FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://increase-max-setuptools-version.patch"

include python3-package-split.inc
