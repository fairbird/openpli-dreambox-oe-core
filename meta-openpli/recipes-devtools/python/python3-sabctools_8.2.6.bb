SUMMARY = "C implementations of functions for use within SABnzbd"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI[md5sum] = "1ddee0d69742acfa36e43e7cdf6f316b"
SRC_URI[sha256sum] = "a256522237cfd84d6d9021bc5b31197eb049b83129dcf6721451392c93831191"

SRC_URI:append = " file://remove-x64-flags.patch"

inherit pypi setuptools3

include python3-package-split.inc
