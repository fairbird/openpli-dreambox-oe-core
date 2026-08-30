DESCRIPTION = "A Pure Python SNMP Package"
SECTION = "devel/python"
PRIORITY = "optional"
RDEPENDS:${PN} = "python3-core"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=57ee828406c11080ad9bd7eabdc5ae1b"

SRCNAME = "pysnmp"

S = "${UNPACKDIR}/${SRCNAME}-${PV}"

inherit pypi python_hatchling

SRC_URI[md5sum] = "208c6578ce0bf2e6cbb5563f4972b8aa"
SRC_URI[sha256sum] = "d0da6726c4d35b1e57027c98e2065928656b0cc5d3ce5a60b3535e1825cc60ee"

include python3-package-split.inc
