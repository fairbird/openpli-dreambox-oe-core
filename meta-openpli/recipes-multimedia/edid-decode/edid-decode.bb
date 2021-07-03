SUMMARY = "EDID decoder and conformance tester"
DESCRIPTION = "edid-decode decodes EDID monitor description data in human-readable format"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://edid-decode.cpp;beginline=1;endline=8;md5=2193df34747fd1a150135ed8b90f3b4e"

inherit gitpkgv

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://git.linuxtv.org/edid-decode.git;protocol=https"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig
