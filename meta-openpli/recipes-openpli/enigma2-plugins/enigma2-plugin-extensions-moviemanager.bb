DESCRIPTION = "Plugin for copy or move more files at once"
MAINTAINER = "ims"
LICENSE = "LicenseRef-Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9432c1f3d564948269193fd19a0ad0fd"

inherit gitpkgv setuptools3-openplugins python3-compileall
PV = "2.0+git"
PKGV = "2.0+git${GITPKGV}"

SRC_URI = "git://github.com/ims21/MovieManager.git;protocol=https;branch=master"

S = "${UNPACKDIR}/${BP}"
