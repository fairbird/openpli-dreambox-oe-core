DESCRIPTION = "NewVirtualKeyBoard plugin by mfaraj57 & RAED"
MAINTAINER = "RAED - fairbird"

require conf/license/license-gplv2.inc

inherit gittag setuptools3-openplugins gettext python3-compileall

RDEPENDS:${PN} += "bash"

SRC_URI = "git://github.com/fairbird/NewVirtualKeyBoard;protocol=https;branch=main"

SRCREV = "${AUTOREV}"

PV = "git"
PKGV = "${GITPKGVTAG}"

FILES:${PN} = "${prefix}/"

do_compile() {
	:
}

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
	python3 -m compileall -o2 -b ${D}${prefix} -d /
}

INSANE_SKIP:${PN} += "already-stripped"
