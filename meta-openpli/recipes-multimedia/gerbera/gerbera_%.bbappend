FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " cxxopts libzip libzippp"

PV = "3.2.1"
PKGV = "3.2.1+git${GITPKGV}"

SRC_URI = "git://github.com/gerbera/gerbera.git;protocol=https;branch=master \
           file://config.xml \
           file://init \
"

SRCREV = "d63e666a0874ff953751f882bd10771717420408"

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
