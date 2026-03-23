DESCRIPTION = "BackUpFlash plugin by (RAED & mfaraj57) to Create Backup and flash. Also to download Some Team images."
MAINTAINER = "RAED - fairbird"

require conf/license/license-gplv2.inc

SRC_URI = "git://github.com/fairbird/BackUpFlash;protocol=https;branch=main"

inherit setuptools3-openplugins gittag python3-compileall

RDEPENDS:${PN} += "\
	wget \
	pigz \
	xz \
	pigz \
	python3-crypt \
	${@bb.utils.contains("MACHINE_FEATURES", "dreamboxv2", "flash-scripts", "", d)} \
	"
SRCREV = "${AUTOREV}"

PV = "git"
PKGV = "${GITPKGVTAG}"

FILES:${PN} = "${prefix}/"

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
	python3 -m compileall -o2 -b ${D}${prefix} -d /
}

INSANE_SKIP:${PN} += "already-stripped"
