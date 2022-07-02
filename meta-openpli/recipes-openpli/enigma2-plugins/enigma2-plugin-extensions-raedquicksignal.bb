DESCRIPTION = "plugin to show information for channels such as (SNR, AGC, picon, encrypted channel info and also to download picons )."
MAINTAINER = "RAED - fairbird"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/fairbird/RaedQuickSignal;protocol=https;branch=main"

inherit gitpkgv distutils-openplugins

RDEPENDS_${PN} += "\
	python-requests \
	python-six \
	"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"

PV = "1.1+git${SRCPV}"
PKGV = "1.1+git${GITPKGV}"

FILES_${PN} = "${prefix}/"

do_compile() {
	python2 -O -m compileall ${S}${prefix}
}

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/RaedQuickSignal/PICONS
	cp -r ${S}/tmp/RaedQuickSignal/* ${D}/usr/lib/enigma2/python/Plugins/Extensions/RaedQuickSignal/PICONS
}

FILES_${PN}-src = "\
    ${libdir}/enigma2/python/*/*.py \
    ${libdir}/enigma2/python/*/*/*.py \
    ${libdir}/enigma2/python/*/*/*/*.py \
    ${libdir}/enigma2/python/*/*/*/*/*.py \
    ${libdir}/enigma2/python/*/*/*/*/*/*.py \
    ${libdir}/enigma2/python/*/*/*/*/*/*/*.py \
    ${libdir}/enigma2/python/*/*/*/*/*/*/*/*.py \
    ${libdir}/enigma2/python/*/*/*/*/*/*/*/*/*.py \
    ${libdir}/enigma2/python/*/*/*/*/*/*/*/*/*/*.py \
    ${libdir}/enigma2/python/*/*/*/*/*/*/*/*/*/*/*.py \
    "

INSANE_SKIP_${PN} += "already-stripped"
