SUMMARY = "Dreambox bootlogo"
LICENSE = "CLOSED"
PV = "1.3"

BINARY_VERSION = "1.3"

SRC_URI = "http://dreamboxupdate.com/download/opendreambox/2.0.0/dreambox-bootlogo/dreambox-bootlogo_${BINARY_VERSION}_${MACHINE}.tar.bz2"

SRC_URI[md5sum] = "1b63ac7e2bd5c0db0748606acc310d47"
SRC_URI[sha256sum] = "91e4402190fe88cf394ae780141d968a1ebecd8db7b23c1f0ca3f4bfa9c9512a"

S = "${WORKDIR}/dreambox-bootlogo_${BINARY_VERSION}_${MACHINE}"

do_install(){
install -d ${D}/boot
install -m 0755 ${S}/bootlogo-${MACHINE}.elf.gz ${D}/boot
install -m 0755 ${S}/bootlogo-${MACHINE}.jpg ${D}/boot
}

FILES_${PN} = "/boot"

pkg_preinst_${PN}_dreambox() {
	if [ -z "$D" ]
	then
		if mountpoint -q /boot
		then
			mount -o remount,rw,compr=none /boot
		else
			mount -t jffs2 -o rw,compr=none mtd:boot /boot
		fi
	fi
}

pkg_postinst_${PN}_dreambox() {
	if [ -z "$D" ]
	then
		umount /boot
	fi
}

pkg_prerm_${PN}_dreambox() {
	if [ -z "$D" ]
	then
		if mountpoint -q /boot
		then
			mount -o remount,rw,compr=none /boot
		else
			mount -t jffs2 -o rw,compr=none mtd:boot /boot
		fi
	fi
}

pkg_postrm_${PN}_dreambox() {
	if [ -z "$D" ]
	then
		umount /boot
	fi
}
