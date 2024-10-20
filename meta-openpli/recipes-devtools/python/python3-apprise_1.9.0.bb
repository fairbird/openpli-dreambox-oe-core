SUMMARY = "Push Notifications that work with just about every platform!"
HOMEPAGE = "https://github.com/caronc/apprise"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b18f7da56457240ed21714dd6a74dd86"

DEPENDS = "python3-babel-native"

RDEPENDS:${PN} = "python3-pyyaml python3-markdown python3-click"

SRC_URI[md5sum] = "55bd36c0b54e55424ad7fdc242413c99"
SRC_URI[sha256sum] = "b5c93afd6331afe4b63a55d1cea9076e47becb4ba89b562b181c13e25bb0c7d6"

inherit pypi python_setuptools_build_meta

include python3-package-split.inc
