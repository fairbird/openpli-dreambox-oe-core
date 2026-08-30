SUMMARY  = "Rebulk - Define simple search patterns in bulk to perform advanced matching on any string."
HOMEPAGE = "https://github.com/Toilal/rebulk/"
SECTION = "devel/python"
LICENSE = "BSD-4-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=df5f9321c8784271adb6c95a3da69f82"

DEPENDS = "python3-uv-build-native"
RDEPENDS:${PN} = "python3-regex"

SRC_URI[md5sum] = "4cd4763a0f4916218e31aeeda69db84f"
SRC_URI[sha256sum] = "d6df0c8c896e160087c6981f3770ed513ec973a9f4066b9e4b0614eb08ba0ce1"

SRC_URI:append = " file://increase-max-version-uv-build.patch"

S = "${WORKDIR}/rebulk-${PV}"

inherit pypi python_hatchling

include python3-package-split.inc
