FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "2.5.0"

SRCREV = "92261f4994b0875a60c6288592fc8bbe953eea25"

SRC_URI:append = " \
	file://fix-build-linking-order.patch \
	file://config.xml \
	file://init \
"

inherit update-rc.d

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

FILES:${PN} += "${sysconfdir} /usr/share/bash-completion"

CONFFILES:${PN} = "${sysconfdir}/gerbera/config.xml"

DEPENDS += "jsoncpp icu"

PV = "2.6.1"

SRCREV = "89b37a28d9f648502c617d15a0194669d0e54a94"
