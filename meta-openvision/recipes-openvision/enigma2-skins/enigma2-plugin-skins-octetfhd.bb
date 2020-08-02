SUMMARY = "Enigma2 Skin OctEtFHD"
MAINTAINER = "Open Vision Developers"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

RRECOMMENDS_${PN} = "enigma2-plugin-extensions-weatherplugin2"

SRC_URI="git://github.com/OpenVisionE2/OctEtFHD-skin.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr"

do_package_qa[noexec] = "1"

do_install() {
    cp -r  --preserve=mode,links ${S}/usr ${D}/
}
