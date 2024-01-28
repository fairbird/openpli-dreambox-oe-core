MODULE = "SimpleUmount"
DESCRIPTION = "Unmounter for mass storage devices"
MAINTAINTER = "ambrosa"

PV_MOD = "0.1+git"
PKGV_MOD = "0.1+git${GITPKGV}"

require openplugins.inc
require openplugins-distutils.inc

SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-SimpleUmount.git;protocol=https;branch=master"

