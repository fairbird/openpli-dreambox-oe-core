SUMMARY = "fake-hwclock - Trivial script to load/save current contents of the kernel clock"
HOMEPAGE = ""
LICENSE = "GPL-2.0-only"
require conf/license/license-gplv2.inc

PV = "1.0"

SRC_URI = "file://fake-hwclock \
           file://fake-hwclock.init \
           file://fake-hwclock.default \
"

inherit update-rc.d

INITSCRIPT_NAME = "fake-hwclock"
INITSCRIPT_PARAMS = "start 01 S . stop 25 0 6 ."

do_configure() {
}

do_compile() {
}

do_install() {
    install -d ${D}${base_bindir}
    install -m 755 ${UNPACKDIR}/fake-hwclock ${D}${base_bindir}

    install -d ${D}${sysconfdir}/default
    install -m 644 ${UNPACKDIR}/fake-hwclock.default ${D}${sysconfdir}/default/fake-hwclock

    install -d ${D}${INIT_D_DIR}
    install -m 755 ${UNPACKDIR}/fake-hwclock.init ${D}${INIT_D_DIR}/fake-hwclock
}

pkg_postinst:${PN}:prepend () {
#!/bin/sh
if [ -n "$D" ]; then
        [[ -f $D${sysconfdir}/fake-hwclock.data ]] || date -u '+%Y-%m-%d %H:%M:%S' > $D${sysconfdir}/fake-hwclock.data
fi
}
