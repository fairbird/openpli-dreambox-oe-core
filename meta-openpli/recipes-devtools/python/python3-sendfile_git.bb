SUMMARY  = "Interface to the sendfile syscall"
HOMEPAGE = "https://github.com/giampaolo/pysendfile"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b8eec2f0885ebe1362d0bdb1617f61b5"

inherit setuptools3 gitpkgv

# Version 2.0.1 is actually over three years old, we're using "master".
PV = "2.0.1+git"
PKGV = "2.0.1+git${GITPKGV}"

SRC_URI = "git://github.com/giampaolo/pysendfile.git;protocol=https;branch=master"
S = "${WORKDIR}/git"

include python3-package-split.inc
