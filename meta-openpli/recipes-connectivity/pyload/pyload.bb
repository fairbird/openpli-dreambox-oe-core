DESCRIPTION = "pyLoad is a fast, lightweight and full featured download manager for many One-Click-Hoster"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2d20d11c1dccf4454ce811d6bfb05a2b"
HOMEPAGE = "http://pyload.org/"

RDEPENDS:${PN} = "\
  ${PYTHON_PN}-compression \
  ${PYTHON_PN}-db \
  ${PYTHON_PN}-email \
  ${PYTHON_PN}-html \
  ${PYTHON_PN}-imaging \
  ${PYTHON_PN}-numbers \
  ${PYTHON_PN}-pprint \
  ${PYTHON_PN}-pycryptodome \
  ${PYTHON_PN}-pycurl \
  ${PYTHON_PN}-sqlite3 \
  ${PYTHON_PN}-terminal \
  ${PYTHON_PN}-unixadmin \
  ${PYTHON_PN}-xmlrpc \
"
RRECOMMENDS:${PN} = "unrar"

PV = "0.5.0"

inherit update-rc.d setuptools3_legacy

SRC_URI = "git://github.com/pyload/pyload.git;branch=main;protocol=https \
	file://pyload.init \
"

S = "${WORKDIR}/git"

FILES:${PN} = "/usr/* /etc/*"

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "defaults 60 "

do_compile() {
	${PYTHON_PN} -m compileall ${S}
}

do_install:append() {
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/pyload.init ${D}/etc/init.d/pyload
}

include ${PYTHON_PN}-package-split.inc
