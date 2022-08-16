FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://opkg.conf \
			file://modprobe \
			"

do_install:prepend() {
	install -d ${D}${datadir}/opkg/intercept
	install -m 755 ${WORKDIR}/modprobe ${D}${datadir}/opkg/intercept/
}
