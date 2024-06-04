FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "2.1.0"

SRCREV = "a9bab24e043b5612a0264dbd753f85e1254a5873"

SRC_URI:append = " \
           file://fix-build-against-fmt-10-2-2.patch \
           file://fix-build-fmt-10-2-pre3.patch \
           file://config.xml \
           file://init \
"

inherit update-rc.d gitpkgv

INITSCRIPT_NAME = "gerbera"
INITSCRIPT_PARAMS = "defaults 90"

do_install:append() {
    install -d ${D}${sysconfdir}/gerbera
    install -m 0755 ${UNPACKDIR}/config.xml ${D}${sysconfdir}/gerbera/config.xml
    if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${UNPACKDIR}/init ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
    fi
}

FILES:${PN} += "${sysconfdir}"

CONFFILES:${PN} = "${sysconfdir}/gerbera/config.xml"
