SUMMARY = "C implementations of functions for use within SABnzbd"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI[md5sum] = "c45d01f07f66664734ebbf729c685c2a"
SRC_URI[sha256sum] = "a19318c6e9038446c4d326c26c6703e343cdcb892d05e8b86e4d2b71c6f70789"

SRC_URI:append = " file://remove-x64-flags.patch"

inherit pypi setuptools3

include python3-package-split.inc
