SUMMARY = "C implementations of functions for use within SABnzbd"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI[md5sum] = "4095b726f71d7e112ce1e8dd08c640b3"
SRC_URI[sha256sum] = "faacd20d5ec9111e39c81326ca1e49a2be2b24b95c13c28f82e3e7ac198c9129"

SRC_URI:append = " file://remove-x64-flags.patch"

inherit pypi setuptools3

include python3-package-split.inc
