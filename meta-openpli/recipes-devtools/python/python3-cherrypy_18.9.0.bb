SUMMARY = "CherryPy is a pythonic, object-oriented HTTP framework"
HOMEPAGE = "https://cheroot.cherrypy.org/"
SECTION = "devel/python"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=a5ad8f932e1fd3841133f20d3ffedda1"
DEPENDS += "python3-setuptools-scm-native"
RDEPENDS:${PN} = "python3-jaraco.collections python3-jaraco.classes python3-jaraco.text python3-jaraco.functools python3-zc.lockfile python3-tempora"

PYPI_PACKAGE = "CherryPy"

SRC_URI[md5sum] = "014dbd400aeda9d2b098ed01c95b4a30"
SRC_URI[sha256sum] = "6b06c191ce71a86461f30572a1ab57ffc09f43143ba8e42c103c7b3347220eb1"

inherit pypi setuptools3_legacy

include python3-package-split.inc
