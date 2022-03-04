SUMMARY = "Preloadable library to improve large file operations"
SECTION = "base"
LICENSE = "CLOSED"
DEPENDS = "libdlsym"

SRCREV = "6e7b3136e17c28697b3dcea597a334022a931b27"

inherit autotools opendreambox-git pkgconfig

FILES:${PN} = "${libdir}/lib*${SOLIBSDEV}"
FILES_SOLIBSDEV = ""

RREPLACES:${PN} += "libpagecache0"
RCONFLICTS:${PN} += "libpagecache0"

pkg_postinst:${PN} () {
[ -z $D ] && sed -i 's|${libdir}/libpagecache.so.0.0.0||g' ${sysconfdir}/ld.so.preload || /bin/true
}

pkg_postrm:${PN} () {
[ -z $D ] && sed -i 's|${libdir}/libpagecache.so.0.0.0||g' ${sysconfdir}/ld.so.preload || /bin/true
}
