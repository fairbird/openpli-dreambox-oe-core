DESCRIPTION = "PD1LOI HD night"
MAINTAINER = "pd1loi1"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://README.md;md5=7d3f230cd39b787fa1d165cd8ce229bf"

inherit gitpkgv allarch

PV = "2.6.1+git"
PKGV = "2.6.1+git${GITPKGV}"

SRC_URI = "git://github.com/PD1LOI/Pd1loi-HD-night.git;protocol=https;branch=main"

FILES:${PN} = "/usr"

S = "${WORKDIR}/git"

do_compile() {
}

do_install() {
	install -d ${D}/usr
	cp -r --preserve=mode,links ${S}/usr/* ${D}/usr/
	chmod -R a+rX ${D}/usr
}
