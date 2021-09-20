DESCRIPTION = "Pre-compiled for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

COMPATIBLE_MACHINE = "^(dreamone|dreamtwo)$"

SRC_URI = "file://others.zip"

S = "${WORKDIR}"

do_configure() {
}

do_compile() {
}

do_install() {
	install -d ${D}${sysconfdir}/u-boot.scr.d
	install -m 0644 ${S}${sysconfdir}/u-boot.scr.d/* ${D}${sysconfdir}/u-boot.scr.d
	install -m 0644 ${S}${sysconfdir}/machine-id ${D}${sysconfdir}/
}

do_package_qa() {
}

do_populate_sysroot() {
}

FILES_${PN} += "/"
