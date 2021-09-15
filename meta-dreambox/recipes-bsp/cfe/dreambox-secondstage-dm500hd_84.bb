require dreambox-secondstage.inc

COMPATIBLE_MACHINE = "^(dm500hd)$"

SRC_URI[md5sum] = "d13c2713f4062a7de53f02f6ae8dba48"
SRC_URI[sha256sum] = "4280e588f85689fca109aeeabd54a98e22674ce0f98fb10c23878d72de54a227"

RDEPENDS_${PN} = ""

pkg_postinst_${PN}() {
	echo "Due to space limitations, this is now a dummy package!"
	echo "Nothing will happen when you try to update or reinstall it!"
	echo "The secondstage bootloader will remain the same!"
}
