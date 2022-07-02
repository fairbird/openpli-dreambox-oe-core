DESCRIPTION = "ArabicSavior plugin by (mfaraj57 & RAED) to fix arabic fonts and also to changing fonts type."
MAINTAINER = "RAED - fairbird"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/fairbird/ArabicSavior;protocol=https;branch=main"

inherit gitpkgv distutils-openplugins

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
