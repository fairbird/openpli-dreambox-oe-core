FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS += "libusb1"
RDEPENDS:${PN} += "libusb1"

SRC_URI:append = " file://pcscd.init"

PACKAGECONFIG = ""

inherit update-rc.d

INITSCRIPT_NAME = "pcscd"
INITSCRIPT_PARAMS = "defaults"

EXTRA_OECONF = " \
    --enable-libusb \
    --enable-usbdropdir=${libdir}/pcsc/drivers \
"

do_install:append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${UNPACKDIR}/pcscd.init ${D}${sysconfdir}/init.d/pcscd
}

FILES:${PN} =+ "${sysconfdir}/*"
