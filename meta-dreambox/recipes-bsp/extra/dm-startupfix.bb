require conf/license/license-gplv2.inc

PV = "1.0"

SRC_URI = "file://startup_fix.sh"

INITSCRIPT_NAME = "startup_fix"
INITSCRIPT_PARAMS = "start 03 S ."

inherit update-rc.d

do_compile() {
}

do_install() {
    install -d ${D}/etc/init.d/
    install -m 0755 ${WORKDIR}/startup_fix.sh ${D}/etc/init.d/startup_fix
}

pkg_postinst_${PN}() {
	mkdir -p $D/etc/enigma2
	touch $D/etc/enigma2/settings
	sed -i '/config\.inputDevices\.event2/d' $D/etc/enigma2/settings
	sed -i '/config\.inputDevices\.event1/d' $D/etc/enigma2/settings
	echo "config.inputDevices.event2.repeat=250" >> $D/etc/enigma2/settings
	echo "config.inputDevices.event2.enabled=true" >> $D/etc/enigma2/settings
	echo "config.inputDevices.event2.name=dreambox advanced remote control (native)" >> $D/etc/enigma2/settings
	echo "config.inputDevices.event1.repeat=250" >> $D/etc/enigma2/settings
	echo "config.inputDevices.event1.enabled=true" >> $D/etc/enigma2/settings
	echo "config.inputDevices.event1.name=dreambox remote control (native)" >> $D/etc/enigma2/settings
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

