SUMMARY = "Python template engine and code generation tool"
HOMEPAGE = "https://cheetahtemplate.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=be4ebd20a0d448789acb1cdd9ceb6026"

PYPI_PACKAGE = "Cheetah3"
inherit setuptools3

SRC_URI = "git://github.com/CheetahTemplate3/cheetah3;protocol=https;branch=master"

SRCREV = "074be1bb8caabf577a7dccc69eef817e32f2f305"

S="${WORKDIR}/git"

RDEPENDS:${PN} = "python3-pickle python3-pprint"
RDEPENDS:${PN}:class-native = ""

BBCLASSEXTEND = "native nativesdk"
