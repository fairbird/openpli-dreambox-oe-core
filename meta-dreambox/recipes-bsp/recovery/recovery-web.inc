SUMMARY = "Provides web pages for the rescue partition"
HOMEPAGE = "http://dreamboxupdate.com/"
LICENSE = "CLOSED"

DEPENDS = "fcgi"

do_install() {
	oe_runmake install DESTDIR=${D}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = "\
	coreutils-stdbuf \
	haserl \
	lighttpd \
	lighttpd-module-cgi \
	lighttpd-module-fastcgi \
	recovery \
	"

#RRECOMMENDS:${PN} = "dreambox-dvb-modules-stb-core"

inherit opendreambox-git
