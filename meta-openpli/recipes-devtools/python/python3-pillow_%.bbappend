FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

include python3-package-split.inc

DEPENDS += " libwebp "

PR .= ".1"
