FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "dd173bc5442a20b3c8429a6d848e770ef96b952f"

SRC_URI = "git://github.com/gabime/spdlog.git;protocol=https;branch=v1.x \
           file://fix-build-gerbera.patch \
"      

PV = "1.11.pre1"
PKGV = "1.11.pre1"
