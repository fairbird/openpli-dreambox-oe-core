SUMMARY = "treq: High-level Twisted HTTP Client API"
DESCRIPTION = "treq is an HTTP library inspired by requests but written \
on top of Twisted's Agents. It provides a simple, higher level API \
for making HTTP requests when using Twisted."
SECTION = "devel/python"
MAINTAINER = "Tom Most <twm@freecog.net>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a5dd67fd17479587f7093769d95ef186"

inherit pypi python_hatchling

SRC_URI[sha256sum] = "43e728e12aca2d897c626cf07dc7b4392749b73de050a7d66e086cb3a6e15da9"

DEPENDS += "python3-incremental-native"

RDEPENDS:${PN} += "python3-attrs python3-hyperlink python3-incremental python3-requests python3-twisted"
RDEPENDS:${PN}-dbg = "${PN}"
FILES:${PN}-dbg = " \
    ${PYTHON_SITEPACKAGES_DIR}/${PN}-*.egg-info \
    ${PYTHON_SITEPACKAGES_DIR}/${PN}/test \
"

SRC_URI:append = " file://fix-broken-module-import.patch"

include python3-package-split.inc

do_compile[network] = "1"
