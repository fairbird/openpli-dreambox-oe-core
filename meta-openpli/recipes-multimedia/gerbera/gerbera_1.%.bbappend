FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://github.com/gerbera/gerbera.git;protocol=https;branch=master \
           file://0001-Fix-build-with-fmt-post-9.1.patch \
           file://config.xml \
           file://init \
"

SRCREV = "63ff8e785ad4d631e519874523d5e31afcfa8933"

PV = "1.12.1"
PKGV = "1.12.1"

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
