SUMMARY = "Internet speed test for enigma2"
MAINTAINER = "madhouse"

require conf/license/license-gplv2.inc

inherit gitpkgv distutils-openplugins gettext

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/fairbird/Internet-Speedtest.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
}

FILES_${PN} = "${prefix}/"
