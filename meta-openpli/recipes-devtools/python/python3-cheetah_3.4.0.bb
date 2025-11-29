SUMMARY = "Python template engine and code generation tool"
HOMEPAGE = "https://cheetahtemplate.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6c8d05debf9d3d283931051ce5232fe7"

PYPI_PACKAGE = "Cheetah3"
inherit setuptools3

SRC_URI = "git://github.com/CheetahTemplate3/cheetah3;protocol=https;branch=master"

SRCREV = "8cfda363eafdae01b2d8d1b481e4247264af2421"

RDEPENDS:${PN} = "python3-pickle python3-pprint"
RDEPENDS:${PN}:class-native = ""

BBCLASSEXTEND = "native nativesdk"
