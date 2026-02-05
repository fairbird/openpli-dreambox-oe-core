SUMMARY = "Context managers by jaraco"
HOMEPAGE = "https://github.com/jaraco/jaraco.context"
SECTION = "devel/python"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2e21c3f75eb8d9427c8a611a8e83e9d6"
DEPENDS += "python3-setuptools-scm-native python3-coherent-licensed-native"

PYPI_PACKAGE = "jaraco_context"

SRC_URI[md5sum] = "a31986312781405369c904eec861fd35"
SRC_URI[sha256sum] = "129a341b0a85a7db7879e22acd66902fda67882db771754574338898b2d5d86f"

inherit pypi python_setuptools_build_meta
