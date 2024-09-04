MODULE = "SimpleUmount"
DESCRIPTION = "Unmounter for mass storage devices"
MAINTAINTER = "ambrosa"

inherit setuptools3-openplugins

PV_MOD = "0.1+git"
PKGV_MOD = "0.1+git${GITPKGV}"

require openplugins.inc

