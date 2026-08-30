SUMMARY = "The icalendar package is a parser/generator of iCalendar files for use with Python."
HOMEPAGE = "http://icalendar.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=c1811377eb97cf603a2fc49ed1b0d37f"

DEPENDS = "python3-pytz python3-dateutil python3-hatch-vcs-native"
RDEPENDS:${PN} = "python3-pytz python3-dateutil python3-zoneinfo"

SRC_URI[md5sum] = "db37770cefe75492fdb29ecaf3f746fc"
SRC_URI[sha256sum] = "7bd001c8e648205e1bde5c6a5b77096598e8d0893dcf57755c6c597635620132"

inherit pypi python_setuptools_build_meta

include python3-package-split.inc
