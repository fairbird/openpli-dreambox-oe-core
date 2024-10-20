SUMMARY = "The icalendar package is a parser/generator of iCalendar files for use with Python."
HOMEPAGE = "http://icalendar.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=1b2957cd26c589d0defcb357be630e80"

DEPENDS = "python3-pytz python3-dateutil python3-hatch-vcs-native"
RDEPENDS:${PN} = "python3-pytz python3-dateutil"

SRC_URI[md5sum] = "8872b21d7f96dd4ad6156021ec51ecc4"
SRC_URI[sha256sum] = "7ddf60d343f3c1f716de9b62f6e80ffd95d03cab62464894a0539feab7b5c76e"

inherit pypi python_setuptools_build_meta

include python3-package-split.inc
