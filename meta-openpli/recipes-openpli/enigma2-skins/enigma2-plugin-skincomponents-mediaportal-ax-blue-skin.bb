SUMMARY = "Full HD Skinpart for Mediaportal by stein17"
MAINTAINER = "stein17"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

inherit gitpkgv

PV = "3.0"
PKGV = "3.0"
VER ="3.0"
PR = "r3"

SRC_URI="git://github.com/stein17/Skins-for-Plugins-by-stein17.git;branch=python3;protocol=https"

S = "${WORKDIR}/git/Mediaportal-AX-Blue-Skin"

FILES:${PN} = "${libdir}"

do_install() {
    install -d ${D}${libdir}
    cp -rp ${S}/usr/lib/* ${D}${libdir}/
}

do_package_qa[noexec] = "1"
