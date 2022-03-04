FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR .= ".2"

SRC_URI += " \
            file://mount_single_uuid.patch \
            file://use_ipv6_when_ipv4_unroutable.patch \
            file://telnetd \
            file://inetd \
            file://inetd.conf \
            file://vi.sh \
            file://ntp.script \
            file://0001-Prevent-telnet-connections-from-the-internet-to-the-.patch \
            file://0002-Extended-network-interfaces-support.patch \
            file://0003-Revert-ip-fix-ip-oneline-a.patch \
            file://0004-libbb-make-unicode-printable.patch \
            "

# we do not really depend on mtd-utils, but as mtd-utils replaces 
# include/mtd/* we cannot build in parallel with mtd-utils
DEPENDS += "mtd-utils"

RDEPENDS:${PN} += "odhcp6c"

PACKAGES =+ "${PN}-inetd"
INITSCRIPT_PACKAGES += "${PN}-inetd"
INITSCRIPT_NAME:${PN}-inetd = "inetd.${BPN}" 
CONFFILES:${PN}-inetd = "${sysconfdir}/inetd.conf"
FILES:${PN}-inetd = "${sysconfdir}/init.d/inetd.${BPN} ${sysconfdir}/inetd.conf"
RDEPENDS:${PN}-inetd += "${PN}"
PROVIDES += "virtual/inetd"
RPROVIDES:${PN}-inetd += "virtual/inetd"
RCONFLICTS:${PN}-inetd += "xinetd"
RRECOMMENDS:${PN} += "${PN}-inetd"

do_install:append() {
	sed -i "/[/][s][h]*$/d" ${D}${sysconfdir}/busybox.links.nosuid
	install -d ${D}${sysconfdir}/udhcpc.d
	install -m 0755 ${WORKDIR}/ntp.script ${D}${sysconfdir}/udhcpc.d/55ntp
}

pkg_postinst:${PN}:append () {
	update-alternatives --install /bin/sh sh /bin/busybox.nosuid 50
}

pkg_prerm:${PN}:append () {
	ln -s ${base_bindir}/busybox $tmpdir/wget
}
