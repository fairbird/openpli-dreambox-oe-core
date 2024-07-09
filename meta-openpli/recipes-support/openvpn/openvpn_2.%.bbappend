# make sure it starts automatically after installation
INITSCRIPT_NAME = "openvpn"
INITSCRIPT_PARAMS = "defaults"

RDEPENDS:${PN} = "lzo lz4"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://update-resolv-conf.sh"

do_install:append() {
	install -m 775 ${UNPACKDIR}/update-resolv-conf.sh ${D}${sysconfdir}/openvpn/update-resolv-conf.sh
}
