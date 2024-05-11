DESCRIPTION = "serviceapp service for enigma2"
AUTHOR = "Maroš Ondrášek <mx3ldev@gmail.com>"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
require classes/python3-compileall.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "enigma2 uchardet openssl"
RDEPENDS:${PN} = "enigma2 uchardet openssl python3-json"
RRECOMMENDS:${PN} = "exteplayer3 gstplayer"

SRC_URI = "git://github.com/mx3L/serviceapp.git;protocol=https;branch=develop \
			file://update-devel-m4-file.patch \
			file://remove-redundant-c17-check.patch \
			file://fix-debug-print.patch \
			file://try-to-fix-streamlink-based-urls.patch \
"

S = "${WORKDIR}/git"

inherit autotools gitpkgv pkgconfig python3native python3targetconfig

PV = "git"
PKGV = "git${GITPKGV}"

EXTRA_OECONF = "\
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

FILES:${PN} = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/ \
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/*.pyc \
    	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/serviceapp.so \
    	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/locale/*/*/*.mo \
    	"

FILES:${PN}-dev = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/serviceapp.la"

FILES:${PN}-src = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/*.py \
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/locale/*/LC_MESSAGES/*.mo \
	/usr/src/debug/* \
	"
