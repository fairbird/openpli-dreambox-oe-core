# make sure it starts automatically after installation
INITSCRIPT_NAME = "openvpn"
INITSCRIPT_PARAMS = "defaults"

PV = "2.7.2"

SRC_URI[sha256sum] = "9c3e150a595fc9a375221f2fa9f10524a9c064536cf81c96e3ba66c735b86f26"

RDEPENDS:${PN} = "lzo lz4"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://update-resolv-conf.sh"
SRC_URI:remove = "file://0001-tests-skip-test-execution-when-cross-compiling.patch"

do_install:append() {
	install -m 775 ${UNPACKDIR}/update-resolv-conf.sh ${D}${sysconfdir}/openvpn/update-resolv-conf.sh
}
