DESCRIPTION = "BackUpFlash plugin by (RAED & mfaraj57) to Create Backup and flash. Also to download Some Team images."
MAINTAINER = "RAED - fairbird"

require conf/license/license-gplv2.inc
require classes/python3-compileall.inc

SRC_URI = "git://github.com/fairbird/BackUpFlash;protocol=https;branch=main"

inherit gitpkgv setuptools3-openplugins

RDEPENDS:${PN} += "\
	wget \
	pigz \
	xz \
	pigz \
	python3-crypt \
	${@bb.utils.contains("MACHINE_FEATURES", "dreamboxv2", "flash-scripts", "", d)} \
	"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"

PV = "1.1+git"
PKGV = "1.1+git${GITPKGV}"

FILES:${PN} = "${prefix}/"

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
	python3 -m compileall -o2 -b ${D}${prefix}
}

do_package_qa[noexec] = "1"

INSANE_SKIP:${PN} += "already-stripped"
