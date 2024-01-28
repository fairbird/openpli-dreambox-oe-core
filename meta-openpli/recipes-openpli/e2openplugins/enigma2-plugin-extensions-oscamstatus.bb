MODULE = "OscamStatus"
DESCRIPTION = "shows status of your oscam server"

PV_MOD = "1.0+git"
PKGV_MOD = "1.0+git${GITPKGV}"

require conf/license/license-gplv2.inc
require openplugins.inc
require openplugins-distutils.inc

SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-OscamStatus.git;protocol=https;branch=master file://use-setuptools-instead-of-distutils.patch"
