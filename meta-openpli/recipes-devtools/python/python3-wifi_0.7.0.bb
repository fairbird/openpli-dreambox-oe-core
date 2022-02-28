SUMMARY = "Provides access to Linux Wireless Extensions"
HOMEPAGE = "http://pythonwifi.wikispot.org/"
SECTION = "devel/python"
LICENSE = "LGPLv2+ & GPLv2+"
LICENSE:${PN}-examples = "GPLv2+"
LIC_FILES_CHKSUM = "file://README;md5=54307cbab01c3aad9adf7605132bcf31"

RDEPENDS:${PN} = "python3-ctypes python3-datetime python3-six"

inherit gitpkgv setuptools3

PV = "0.7.0+git${SRCPV}"
PKGV = "0.7.0+git${GITPKGV}"
PR = "r2"

SRC_URI = "git://github.com/athoik/pythonwifi.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

do_install:append() {
		install -d ${D}${docdir}/${PN}
		mv ${D}${datadir}/README ${D}${docdir}/${PN}
		mv ${D}${datadir}/docs/* ${D}${docdir}/${PN}
		rmdir ${D}${datadir}/docs
		install -d ${D}${sbindir}
		mv ${D}${datadir}/examples/* ${D}${sbindir}
		rmdir ${D}${datadir}/examples
}

PACKAGES =+ "${PN}-examples"

FILES:${PN}-examples = "${sbindir}"

include python-package-split.inc
