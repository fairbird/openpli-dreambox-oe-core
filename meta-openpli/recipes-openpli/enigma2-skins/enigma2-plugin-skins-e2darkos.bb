DESCRIPTION = "E2-DarkOS is a modern graphic skin by DimitarCC"
MAINTAINER = "DimitarCC"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit gitpkgv allarch python3-compileall

RRECOMMENDS:${PN} = "enigma2-boxlogos"

PV = "1.1+git"
PKGV = "1.1+git${GITPKGV}"

SRC_URI = "git://github.com/DimitarCC/E2-DarkOS-skin.git;protocol=https;branch=main  \
		file://patch-skin-to-more-compatible.patch \
"
# files installed by both enigma2 and enigma2-plugin-skins-e2darkos
do_install:append() {
        rm -f ${D}/usr/lib/enigma2/python/Components/Converter/CaidInfo2.py
        rm -f ${D}/usr/lib/enigma2/python/Components/Converter/CaidInfo2.pyc
        rm -f ${D}/usr/lib/enigma2/python/Components/Renderer/AudioIcon.py
        rm -f ${D}/usr/lib/enigma2/python/Components/Renderer/AudioIcon.pyc
}

do_install() {
	install -d ${D}${prefix}
	cp -r --no-preserve=ownership ${S}${prefix}/* ${D}${prefix}/
}

FILES:${PN} = "${prefix}/"
FILES:${PN}-src = "${prefix}/lib/enigma2/python/Components/Converter/*.py ${prefix}/lib/enigma2/python/Components/Renderer/*.py"
