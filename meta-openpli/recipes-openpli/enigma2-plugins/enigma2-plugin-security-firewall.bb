DESCRIPTION = "Firewall"

require conf/license/openpli-gplv2.inc
require classes/python3-compileall.inc

RDEPENDS:${PN} = " \	
	${@bb.utils.contains_any("MACHINE", "dreamone dreamtwo", "", \
	" \
	iptables \
	kernel-module-ip-tables \
	kernel-module-xt-state \
	kernel-module-nf-conntrack \
	kernel-module-ipt-reject \
	kernel-module-iptable-filter \
	", d)} \
	"

SRC_URI = "file://firewall.sh file://firewall.users"

PV = "1.0"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

INITSCRIPT_NAME = "firewall"
INITSCRIPT_PARAMS = "defaults"

inherit update-rc.d

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${UNPACKDIR}/firewall.sh ${D}${sysconfdir}/init.d/firewall
	install -d ${D}${sysconfdir}
	install -m 0755 ${UNPACKDIR}/firewall.users ${D}${sysconfdir}/firewall.users
}
