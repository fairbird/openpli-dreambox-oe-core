DESCRIPTION = "WeatherPlugin by Dr.Best modified by RAED"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

require classes/python3-compileall.inc

inherit gitpkgv setuptools3-openplugins gettext

PV = "2.2+git"
PKGV = "2.2+git${GITPKGV}"

SRC_URI = "git://github.com/fairbird/WeatherPlugin.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

FILES:${PN} = "${prefix}/"

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
	python3 -m compileall -o2 -b ${D}${prefix}
}

INSANE_SKIP:${PN} += "already-stripped"


