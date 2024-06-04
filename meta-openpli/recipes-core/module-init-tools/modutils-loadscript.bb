SECTION = "base"
DESCRIPTION = "Load hotplug modules at boot"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://modload.sh;beginline=2;endline=2;md5=3582b3015888936cabf777918af3d3e2"
SRC_URI = "file://modload.sh"
PV = "3"
PR = "r0"

INITSCRIPT_NAME = "modload.sh"
INITSCRIPT_PARAMS = "start 06 S ."

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

inherit update-rc.d

do_compile () {
}

do_install () {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${UNPACKDIR}/modload.sh ${D}${sysconfdir}/init.d/
}
