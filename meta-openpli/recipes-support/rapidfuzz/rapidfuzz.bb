DESCRIPTION = "RapidFuzz provides libraries for fuzzy string matching in various programming languages."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/README.md;md5=a4e4fa0d1e6816df0d77aef42a515dbb"

DEPENDS += "python3-cython-native"

SRC_URI = "git://github.com/rapidfuzz/rapidfuzz;branch=main;protocol=https"
inherit gitpkgv pkgconfig scikit-build-core

PV = "3.15.0.+git"
PKGV = "3.15.0+git${GITPKGV}"

FILES:${PN} = "${PYTHON_SITEPACKAGES_DIR}"
