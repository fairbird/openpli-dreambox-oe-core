DESCRIPTION = "Livestreamersrv is a helper deamon for livestreamer"
SECTION = "devel/python"
MAINTAINER = "SatDreamGR"
HOMEPAGE = "www.satdreamgr.com"
LICENSE = "GPL-2.0-only"
require conf/license/license-gplv2.inc

inherit allarch

RDEPENDS:${PN} = "python3-core streamlink"

inherit python3-dir gitpkgv

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/oe-mirrors/livestreamersrv;protocol=https;branch=master"

S = "${WORKDIR}/git"

do_install:append() {
    install -d ${D}${sbindir}
    install -d ${D}${datadir}
    install -d ${D}${sysconfdir}/init.d
    install -d ${D}${sysconfdir}/rc3.d
    install -d ${D}${sysconfdir}/rc4.d
    install -m 0755 ${S}/livestreamersrv ${D}${sbindir}
    install -m 0644 ${S}/offline.mp4 ${D}${datadir}
    ln -sf ${sbindir}/livestreamersrv ${D}${sysconfdir}/init.d/livestreamersrv
    ln -sf ../init.d/livestreamersrv ${D}${sysconfdir}/rc3.d/S50livestreamersrv
    ln -sf ../init.d/livestreamersrv ${D}${sysconfdir}/rc4.d/S50livestreamersrv
}

FILES:${PN} = "/"


