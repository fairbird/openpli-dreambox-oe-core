SUMMARY = "Push Notifications that work with just about every platform!"
HOMEPAGE = "https://github.com/caronc/apprise"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d1700c468c259a17fcf7f51af33a4a2e"

DEPENDS = "python3-babel-native python3-wheel-native"

RDEPENDS:${PN} = "python3-pyyaml python3-markdown python3-click"

SRC_URI[md5sum] = "2b51e5c913f2ad9a72b454649ab8ddbb"
SRC_URI[sha256sum] = "9a56964bf3ca004b3e0db98ab8a8d87fad051d8edb377bc166dc4be826666c81"

inherit pypi python_setuptools_build_meta

include python3-package-split.inc
