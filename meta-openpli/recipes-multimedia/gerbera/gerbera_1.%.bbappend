FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://github.com/gerbera/gerbera.git;protocol=https;branch=master \
           file://0001-Fix-build-with-fmt-post-9.1.patch \
           file://config.xml \
           file://init \
"

SRCREV = "4020de403598638776cff6c0cba975ec89a031b8"

PV = "1.12.pre2"
PKGV = "1.12.pre2"

inherit update-rc.d

INITSCRIPT_NAME = "gerbera"
INITSCRIPT_PARAMS = "defaults 90"

do_install:append() {
    install -d ${D}${sysconfdir}/gerbera
    install -m 0755 ${WORKDIR}/config.xml ${D}${sysconfdir}/gerbera/config.xml
    if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
    fi
}

FILES:${PN} += "${sysconfdir}"

CONFFILES:${PN} = "${sysconfdir}/gerbera/config.xml"
