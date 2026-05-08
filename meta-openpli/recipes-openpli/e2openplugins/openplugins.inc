require conf/license/license-gplv2.inc

BRANCH ?= "python3"

SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-${MODULE}.git;protocol=https;branch=${BRANCH}"
inherit pkgconfig gitpkgv

PV_MOD ?= "2.0+git"
PKGV_MOD ?= "2.0+git${GITPKGV}"

PV = "${PV_MOD}"
PKGV = "${PKGV_MOD}"
PR = "r0"
