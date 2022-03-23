SUMMARY = "Internet speed test for enigma2"
MAINTAINER = "madhouse"

require conf/license/license-gplv2.inc

include python3-package-split.inc

inherit gitpkgv distutils-openplugins gettext

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI="git://github.com/fairbird/Internet-Speedtest.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
	python3 -m compileall -o2 -b ${D}${prefix}
}

FILES:${PN} = "${prefix}/"

RDEPENDS:{PN}-src = "${PN}"
FILES:${PN}-src = " \
        ${libdir}/enigma2/python/Plugins/Extensions/InternetSpeedTest/*.py \
        ${libdir}/enigma2/python/Components/Converter/*.py \
        "
