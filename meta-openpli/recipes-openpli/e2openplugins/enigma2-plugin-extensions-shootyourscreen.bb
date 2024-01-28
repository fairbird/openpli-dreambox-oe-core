MODULE = "ShootYourScreen"
DESCRIPTION = "create screenshots with remote control of your STB"
PACKAGE_ARCH = "${MACHINE_ARCH}"
RDEPENDS:${PN} = "aio-grab"

PV_MOD = "0.2+git"
PKGV_MOD = "0.2+git${GITPKGV}"

require conf/license/license-gplv2.inc
require openplugins.inc
require openplugins-distutils.inc
