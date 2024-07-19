DESCRIPTION = "xtraEvent plugin by digiteng to show extra events for enigma2 skins."
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/fairbird/xtraEvent;protocol=https;branch=main"

inherit gitpkgv setuptools3-openplugins

include python3-package-split.inc

RDEPENDS:${PN} += "\
	python3-image \
	python3-imaging \
	python3-requests \
	"

S = "${WORKDIR}/git"

PV = "5.2+git"
PKGV = "5.2+git${GITPKGV}"

FILES:${PN} = "${prefix}/"

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
	python3 -m compileall -o2 -b ${D}${prefix}
}

RDEPENDS:{PN}-src = "${PN}"
FILES:${PN}-src = " \
        ${libdir}/enigma2/python/Plugins/Extensions/*/*.py \
        ${libdir}/enigma2/python/Components/*/*.py \
        "

INSANE_SKIP:${PN} += "file-rdeps"

do_package_qa[noexec] = "1"
