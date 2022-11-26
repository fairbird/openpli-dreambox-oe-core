inherit opendreambox-precompiled-binary-new

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = "flash-scripts"

#pkg_postinst:${PN}() {
#[ -n "$D" ] || flash-fsbl
#}

do_compile[noexec] = "1"
