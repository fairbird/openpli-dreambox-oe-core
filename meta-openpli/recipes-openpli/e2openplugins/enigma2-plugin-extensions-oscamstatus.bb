MODULE = "OscamStatus"
DESCRIPTION = "shows status of your oscam server"

PV_MOD = "1.0+git"
PKGV_MOD = "1.0+git${GITPKGV}"

require openplugins.inc
inherit setuptools3-openplugins

BRANCH = "master"

SRC_URI:append = " file://use-setuptools-instead-of-distutils.patch"
