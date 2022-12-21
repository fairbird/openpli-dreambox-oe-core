SUMMARY = "Python template engine and code generation tool"
HOMEPAGE = "https://cheetahtemplate.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=be4ebd20a0d448789acb1cdd9ceb6026"

PYPI_PACKAGE = "Cheetah3"
inherit setuptools3

SRC_URI = "https://files.pythonhosted.org/packages/28/79/5111009d8cf8a46f8e5f0731e726305d933dfb5d158016aa65a6a9f209d8/CT3-3.3.0.post1.tar.gz"

S="${WORKDIR}/CT3-3.3.0.post1"

RDEPENDS:${PN} = "python3-pickle python3-pprint"
RDEPENDS:${PN}:class-native = ""

BBCLASSEXTEND = "native nativesdk"

SRC_URI[sha256sum] = "03bec0c112f53b8e76f1345778e18e9d80dfab87223f7e904d003a5b04722d50"
