SUMMARY = "C implementations of functions for use within SABnzbd"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=892f569a555ba9c07a568a7c0c4fa63a"

DEPENDS = "python3-scikit-build-core-native ninja-native"

SRC_URI[md5sum] = "48d24db2ef3e37b9a697a743ffcb7039"
SRC_URI[sha256sum] = "d84b82c238cba7924f5e0989bbc125816a6aeab1a9f1c151073c803ee567b40d"

SRC_URI:append = " file://remove-x64-flags.patch"

inherit pypi python_hatchling

include python3-package-split.inc

INSANE_SKIP:${PN} += "already-stripped"
