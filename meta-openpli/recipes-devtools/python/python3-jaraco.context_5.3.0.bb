SUMMARY = "Context managers by jaraco"
HOMEPAGE = "https://github.com/jaraco/jaraco.context"
SECTION = "devel/python"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7a7126e068206290f3fe9f8d6c713ea6"
DEPENDS += "python3-setuptools-scm-native"

SRC_URI[md5sum] = "e876ac2f03352e21f59878702ceb26d8"
SRC_URI[sha256sum] = "c2f67165ce1f9be20f32f650f25d8edfc1646a8aeee48ae06fb35f90763576d2"

inherit pypi python_setuptools_build_meta


