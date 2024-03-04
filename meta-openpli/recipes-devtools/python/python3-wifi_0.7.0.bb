SUMMARY = "Provides access to Linux Wireless Extensions"
HOMEPAGE = "http://pythonwifi.wikispot.org/"
SECTION = "devel/python"
LICENSE = "LGPL-2.0-only & GPL-2.0-only"
LICENSE:${PN}-examples = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://README;md5=54307cbab01c3aad9adf7605132bcf31"

RDEPENDS:${PN} = "python3-ctypes python3-datetime python3-six"

inherit gitpkgv setuptools3

PV = "0.7.0+git"
PKGV = "0.7.0+git${GITPKGV}"
PR = "r2"

SRC_URI = "git://github.com/athoik/pythonwifi.git;protocol=https;branch=master \
           file://replace-distutils-with-setuptools.patch \
"

S = "${WORKDIR}/git"

do_install:append() {
    install -d ${D}${docdir}/${PN}
    mv ${D}${prefix}/README ${D}${docdir}/${PN}
    mv ${D}${prefix}/docs/* ${D}${docdir}/${PN}
    mv ${D}${prefix}/man/* ${D}${docdir}/${PN}
    rmdir ${D}${prefix}/docs
    rmdir ${D}${prefix}/man
    install -d ${D}${sbindir}
    mv ${D}${prefix}/examples/* ${D}${sbindir}
    rmdir ${D}${prefix}/examples
}

PACKAGES =+ "${PN}-examples"

FILES:${PN}-examples = "${datadir}/docdir/ ${sbindir}"

include python3-package-split.inc
