SUMMARY = "A very fast JSON encoder/decoder for Python modified for e2iplayer"
HOMEPAGE = "https://github.com/e2iplayer/python-cjson"
LICENSE = "LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0816bf71e8b244e6de5618a54522e845"

SRC_URI = "git://github.com/Hains/python3-cjson.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit gitpkgv setuptools3-openplugins

PV = "1.2.1+git"
PKGV = "1.2.1+git${GITPKGV}"

SETUPTOOLS_INSTALL_ARGS = "\
    --root=${D} \
    --install-data=${datadir} \
    --install-lib=${libdir}/enigma2/python/Plugins/Extensions/IPTVPlayer/libs/e2icjson \
    "

# Remove "egg-info" files.
setuptools3_do_install:append() {
	rm -r ${D}${libdir}/enigma2/python/Plugins/Extensions/IPTVPlayer/libs/e2icjson/*.egg-info
}

include python3-package-split.inc
