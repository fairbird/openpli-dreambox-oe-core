FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "  \
			file://smbnetfs.common.conf \
			file://smbnetfs.user.conf \
			file://init \
			"

FILES:${PN} += "${sysconfdir}/*.conf ${sysconfdir}/init.d"
CONFFILES:${PN} = "${sysconfdir}/smbnetfs.user.conf"
inherit update-rc.d

INITSCRIPT_NAME = "${PN}.sh"

do_install:append() {
	install -d ${D}${sysconfdir}
	install -m 600 ${UNPACKDIR}/smbnetfs.common.conf ${D}${sysconfdir}/
	install -m 600 ${UNPACKDIR}/smbnetfs.user.conf ${D}${sysconfdir}/
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${UNPACKDIR}/init ${D}${sysconfdir}/init.d/${PN}.sh
}
