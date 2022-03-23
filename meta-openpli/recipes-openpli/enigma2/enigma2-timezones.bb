SUMMARY = "timezone.xml for enigma2"
LICENSE = "CLOSED"
require conf/license/license-close.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI="git://github.com/oe-alliance/oe-alliance-tuxbox-common.git;protocol=https;branch=master"

FILES:${PN} = "/"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/etc/tuxbox/

    install -m 0644 ${S}/src/timezone.xml ${D}/etc/tuxbox/timezone.xml
    ln -sf /etc/tuxbox/timezone.xml ${D}/etc/
}
