SUMMARY = "C implementations of functions for use within SABnzbd"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI[md5sum] = "da1d1d2d96c0b62951acfd546dcbf12d"
SRC_URI[sha256sum] = "ad023809282dd7707c246149d800dcc6195284fdb7cb4a55ecce52b1c98793e8"

SRC_URI:append = " file://remove-x64-flags.patch"

inherit pypi setuptools3

include python3-package-split.inc