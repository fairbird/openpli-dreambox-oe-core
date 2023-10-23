DESCRIPTION = "Library that implements bitrate calculations from enigma2"
LICENSE = "CC-BY-NC-ND-4.0"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

DEPENDS = "enigma2"

inherit autotools gitpkgv pkgconfig python3native python3targetconfig
include python3-package-split.inc

SRCREV = "${AUTOREV}"
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/fairbird/bitratecalc.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

do_compile:append() {
    python3 -O -m compileall ${S}
}

FILES:${PN} = "${libdir}/bitratecalc.so"
