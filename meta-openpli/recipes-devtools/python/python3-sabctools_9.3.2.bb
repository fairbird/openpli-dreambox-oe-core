SUMMARY = "C implementations of functions for use within SABnzbd"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI[md5sum] = "823f3579c31cf697bd8b6435952dfeaa"
SRC_URI[sha256sum] = "04a906e78b88426d58b0a92d957d17a847ccdec4944f59cdfe665dd127c7eeec"

SRC_URI:append = " file://remove-x64-flags.patch"

inherit pypi setuptools3

include python3-package-split.inc
