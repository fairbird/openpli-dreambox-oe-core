SUMMARY = "Cheroot is the high-performance, pure-Python HTTP server used by CherryPy"
HOMEPAGE = "https://cheroot.cherrypy.org/"
SECTION = "devel/python"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=c4e17b64eab9c128f786f44f0dfb570a"
DEPENDS += "python3-setuptools-scm-native"

SRC_URI[md5sum] = "5299bba86f892b2a8e7f1678e45b96ff"
SRC_URI[sha256sum] = "dd414eda6bdb15140e864bc1d1c9625030375d14cbe0b290092867368924a52f"

inherit pypi python_hatchling

include python3-package-split.inc
