SUMMARY = "Internet speed test for enigma2"
MAINTAINER = "madhouse"

require conf/license/license-gplv2.inc

inherit gitpkgv setuptools3-openplugins gettext

PV = "git"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/fairbird/Internet-Speedtest.git;protocol=https;branch=master"
do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
	python3 -m compileall -o2 -b ${D}${prefix} -d /
}

FILES:${PN} = "${prefix}/"


