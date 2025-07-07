S = "${UNPACKDIR}/git"

inherit gitpkgv

VERSION := "${PV}"
PV = "${VERSION}+git"
PKGV = "${VERSION}+git${GITPKGV}"
