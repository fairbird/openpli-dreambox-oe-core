DESCRIPTION = "RapidFuzz provides libraries for fuzzy string matching in various programming languages."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/README.md;md5=3afd99a254ea5aba925a0a915e2672d4"

DEPENDS += "python3-cython-native"

SRC_URI = "git://github.com/rapidfuzz/rapidfuzz;branch=main;protocol=https"
inherit gitpkgv pkgconfig scikit-build-core

PV = "3.15.0.+git"
PKGV = "3.15.0+git${GITPKGV}"

FILES:${PN} = "${PYTHON_SITEPACKAGES_DIR}"
