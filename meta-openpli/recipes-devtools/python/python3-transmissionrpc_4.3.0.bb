DESCRIPTION = "Transmission RPC is a python module that can communicate with the bittorrent client Transmission through json-rpc"
HOMEPAGE = "http://bitbucket.org/blueluna/transmissionrpc/wiki/Home"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0fbf1900d3022358b905196180f6b937"

RDEPENDS:${PN} = "python3-simplejson"

SRC_URI = "https://files.pythonhosted.org/packages/61/15/98fcf6c008d8046b815bf56a4539c5e5c32aa35260de4c5042e6cdde5520/transmission_rpc-4.3.0.tar.gz"

SRC_URI[sha256sum] = "8c29ee7021f7515ca943eae24a0f29c9ab7dc445c500f76f457023c940ea8f85"

S = "${WORKDIR}/transmission_rpc-${PV}"

inherit python_poetry_core python_setuptools_build_meta

include python3-package-split.inc
