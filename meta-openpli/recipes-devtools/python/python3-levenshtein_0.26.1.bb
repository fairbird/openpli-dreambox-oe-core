UMMARY = "Python Levenshtein"
HOMEPAGE = "http://github.com/joncasdam/python-Levenshtein"
SECTION = "devel/python"
DEPENDS = "python3"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = " file://COPYING;md5=24b9569831c46d4818450b55282476b4"

DEPENDS = "python3"

PYPI_PACKAGE = "Levenshtein"

SRC_URI[sha256sum] = "b454dd13708546649f1cba2a0f450dd98e7c1679a92e2d6f0a8b8c013c276e55"

S = "${WORKDIR}/python_levenshtein-${PV}"

inherit pypi python_setuptools_build_meta

include python3-package-split.inc
