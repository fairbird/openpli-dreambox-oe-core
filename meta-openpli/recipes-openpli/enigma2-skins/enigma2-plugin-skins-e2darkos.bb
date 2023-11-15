DESCRIPTION = "E2-DarkOS is a modern graphic skin by DimitarCC"
MAINTAINER = "DimitarCC"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit gitpkgv allarch python3-compileall

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/DimitarCC/E2-DarkOS-skin.git;protocol=https;branch=main"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
}

FILES:${PN} = "${prefix}/"
