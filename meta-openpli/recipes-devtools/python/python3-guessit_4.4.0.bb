SUMMARY = "GuessIt - a library for guessing information from video filenames."
HOMEPAGE = "https://doc.guessit.io/"
SECTION = "devel/python"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bb3ca60759f3202f1ae42e3519cd06bc"

SRC_URI[md5sum] = "9fa80ab64b9b2c42350cb61db9e206be"
SRC_URI[sha256sum] = "cca2c19ecd872c75ee7ebcbdc11075f5ae884882ec0ad67f742c3d25f2d47beb"

inherit pypi python_hatchling

include python3-package-split.inc
