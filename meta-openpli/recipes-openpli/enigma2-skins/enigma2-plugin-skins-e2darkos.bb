DESCRIPTION = "E2-DarkOS is a modern graphic skin by DimitarCC"
MAINTAINER = "DimitarCC"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit gitpkgv allarch
require classes/python3-compileall.inc

RRECOMMENDS:${PN} = "enigma2-boxlogos"

PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/DimitarCC/E2-DarkOS-skin.git;protocol=https;branch=main"

S = "${WORKDIR}/git"

# files installed by both enigma2 and enigma2-plugin-skins-e2darkos
do_install:append() {
        rm -f ${D}/usr/lib/enigma2/python/Components/Converter/CaidInfo2.py
        rm -f ${D}/usr/lib/enigma2/python/Components/Converter/CaidInfo2.pyc
        rm -f ${D}/usr/lib/enigma2/python/Components/Renderer/AudioIcon.py
        rm -f ${D}/usr/lib/enigma2/python/Components/Renderer/AudioIcon.pyc
}

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
}

FILES:${PN} = "${prefix}/"
