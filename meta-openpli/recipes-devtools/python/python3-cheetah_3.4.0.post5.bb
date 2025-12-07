SUMMARY = "Python template engine and code generation tool"
HOMEPAGE = "https://cheetahtemplate.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6c8d05debf9d3d283931051ce5232fe7"

PYPI_PACKAGE = "Cheetah3"
inherit setuptools3

SRC_URI = "git://github.com/CheetahTemplate3/cheetah3;protocol=https;branch=master"

SRCREV = "813b30ebe39e4d56c14ee550df2109743e246de7"

RDEPENDS:${PN} = "python3-pickle python3-pprint"
RDEPENDS:${PN}:class-native = ""

BBCLASSEXTEND = "native nativesdk"
