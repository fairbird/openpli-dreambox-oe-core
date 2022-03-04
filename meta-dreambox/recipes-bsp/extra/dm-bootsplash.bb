SUMMARY = "Dreambox boot splash screen"
SECTION = "base"
PRIORITY = "required"
PACKAGE_ARCH = "${MACHINE_ARCH}"
LICENSE = "CLOSED"

COMPATIBLE_MACHINE = "^(dm500hd|dm800se|dm500hdv2|dm800sev2|dm7020hd|dm8000)$"

BINARY_VERSION = "1.3"
PV = "${BINARY_VERSION}"

S = "${WORKDIR}"

SRC_URI = "http://dreamboxupdate.com/download/opendreambox/2.0.0/dreambox-bootlogo/dreambox-bootlogo_${BINARY_VERSION}_${MACHINE}.tar.bz2;name=${MACHINE}"

SRC_URI[dm500hd.md5sum] = "b9ada70304ca1f9a8e36a55bd38834c6"
SRC_URI[dm500hd.sha256sum] = "d4b0f650711d5d6fdecb42efe9e13987ef803cba829d0950e899608a784ae3b2"
SRC_URI[dm800se.md5sum] = "3413a894a3d77e02cae34b96d302817d"
SRC_URI[dm800se.sha256sum] = "8a283442c231e82ee1a2093e53dc5bf52c478e12d22c79af7e7026b52711fc9c"
SRC_URI[dm8000.md5sum] = "1b63ac7e2bd5c0db0748606acc310d47"
SRC_URI[dm8000.sha256sum] = "91e4402190fe88cf394ae780141d968a1ebecd8db7b23c1f0ca3f4bfa9c9512a"
SRC_URI[dm7020hd.md5sum] = "f8e423dbf7661367659fa86a68b74bc4"
SRC_URI[dm7020hd.sha256sum] = "118d7bb57c4b41dd45c7bdd9a056a0745454f42092692fb4309997e035eb6908"
SRC_URI[dm800sev2.md5sum] = "a570f8f2eb4d7800a2fa2db60d81b58e"
SRC_URI[dm800sev2.sha256sum] = "af522a5d4dc75507f2cd96582a270236fedade35b8dca74c0f75d999ffb210bf"
SRC_URI[dm500hdv2.md5sum] = "c0413bfe6c03efc5fa1825b6ad8ac7bd"
SRC_URI[dm500hdv2.sha256sum] = "005b9e99566fdee4d76ec1532273dc3e29a14b723d0bf6108228988e2a30d013"

do_install() {
    install -d ${D}/boot
    install -m 0755 ${S}/dreambox-bootlogo_${BINARY_VERSION}_${MACHINE}/bootlogo-${MACHINE}.elf.gz ${D}/boot/
    install -m 0755 ${S}/dreambox-bootlogo_${BINARY_VERSION}_${MACHINE}/bootlogo-${MACHINE}.jpg ${D}/boot/
}

inherit deploy

pkg_postinst:${PN}() {
	if [ -z "$D" ]
	then
		umount /boot
	fi
}

pkg_prerm:${PN}() {
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

pkg_postrm:${PN}() {
	if [ -z "$D" ]
	then
		umount /boot
	fi
}

FILES:${PN} = "/boot"
