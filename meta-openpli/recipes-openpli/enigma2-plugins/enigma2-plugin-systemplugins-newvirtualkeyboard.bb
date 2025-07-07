DESCRIPTION = "NewVirtualKeyBoard plugin by mfaraj57 & RAED"
MAINTAINER = "RAED - fairbird"

require conf/license/license-gplv2.inc

SRC_URI = "git://github.com/fairbird/NewVirtualKeyBoard;protocol=https;branch=main"

inherit gitpkgv setuptools3-openplugins gettext python3-compileall

S = "${UNPACKDIR}/git"

SRCREV = "${AUTOREV}"

PV = "13.1+git"
PKGV = "13.1+git${GITPKGV}"

FILES:${PN} = "${prefix}/"

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
	python3 -m compileall -o2 -b ${D}${prefix} -d /
}

INSANE_SKIP:${PN} += "already-stripped"


