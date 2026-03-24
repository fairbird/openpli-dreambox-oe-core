SUMMARY = "C implementations of functions for use within SABnzbd"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI[md5sum] = "00e6b912bdb8052365229ff150b1f908"
SRC_URI[sha256sum] = "264451b599f3a7cddd30a5e2baa3976939bc50ea649219a31f6cac4bc4d8d032"

SRC_URI:append = " file://remove-x64-flags.patch"

inherit pypi setuptools3

include python3-package-split.inc
