FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " libzip libzippp"

SRC_URI:append = " \
           file://config.xml \
           file://init \
"

PV = "3.1.1"

SRCREV = "cdb3941ad837bb69b61893d8a3e34228f52c31d5"

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
