require conf/license/license-gplv2.inc

PV = "1.0"

SRC_URI = "file://dm-shutdown.sh"

INITSCRIPT_NAME = "dm-shutdown"
INITSCRIPT_PARAMS = "start 39 0 ."

inherit update-rc.d

do_compile() {
}

do_install() {
    install -d ${D}/etc/init.d/
    install -m 0755 ${WORKDIR}/dm-shutdown.sh ${D}/etc/init.d/dm-shutdown
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

