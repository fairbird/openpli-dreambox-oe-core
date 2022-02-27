SUMMARY = "Internet speed test for enigma2"
MAINTAINER = "madhouse"

require conf/license/license-gplv2.inc

inherit gitpkgv distutils-openplugins gettext

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/Internet-Speedtest.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
}

FILES:${PN} = "${prefix}/"
