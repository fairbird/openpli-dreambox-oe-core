# make sure it starts automatically after installation
INITSCRIPT_NAME = "openvpn"
INITSCRIPT_PARAMS = "defaults"

PV = "2.7.4"

SRC_URI:remove = "http://swupdate.openvpn.org/community/releases/${BP}.tar.gz"
SRC_URI:prepend = "https://github.com/OpenVPN/openvpn/releases/download/v${PV}/${BP}.tar.gz "
SRC_URI[sha256sum] = "18db05f3d5eee3663db1914590044e5f96ff5cd47b6e7846c6a350806c23dbce"

RDEPENDS:${PN} = "lzo lz4"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://update-resolv-conf.sh"
SRC_URI:remove = "file://0001-tests-skip-test-execution-when-cross-compiling.patch"

do_install:append() {
	install -m 775 ${UNPACKDIR}/update-resolv-conf.sh ${D}${sysconfdir}/openvpn/update-resolv-conf.sh
}
