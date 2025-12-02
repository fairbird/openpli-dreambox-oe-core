DESCRIPTION = "Aglare-skin"
MAINTAINER = "lululla"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

inherit gitpkgv allarch python3-compileall

PV = "1.2+git${SRCPV}"
PKGV = "1.2+git${GITPKGV}"
VER = "4.7"
PR = "r0"

SRC_URI = "git://github.com/Belfagor2005/enigma2-plugin-skins-aglare.git;protocol=https;branch=main"

FILES:${PN} = "${prefix}/"

do_compile() {
    :
}

do_install() {
    install -d ${D}/usr
    cp -r --preserve=mode,links ${S}/usr/* ${D}/usr/
    chmod -R a+rX ${D}/usr
}

INSANE_SKIP:${PN} = "installed-vs-shipped"
