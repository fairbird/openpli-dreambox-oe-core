SUMMARY = "Context managers by jaraco"
HOMEPAGE = "https://github.com/jaraco/jaraco.context"
SECTION = "devel/python"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2e21c3f75eb8d9427c8a611a8e83e9d6"

DEPENDS += "python3-setuptools-scm-native python3-coherent-licensed-native"

PYPI_PACKAGE = "jaraco_context"

SRC_URI[md5sum] = "9e91175801a3694e0b0d40e6eacc70b7"
SRC_URI[sha256sum] = "bc046b2dc94f1e5532bd02402684414575cc11f565d929b6563125deb0a6e581"

inherit pypi python_setuptools_build_meta
