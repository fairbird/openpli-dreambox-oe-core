SUMMARY = "ushare is a UPnP media server"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

HOMEPAGE = "http://ushare.geexbox.org/"
DEPENDS = "libupnp virtual/libiconv virtual/libintl gettext"

SRC_URI = " git://github.com/ddugovic/uShare.git;branch=master;protocol=https \
			file://remove-lsb-dependency.patch \
			file://ushare.conf \
			file://init \
"

inherit autotools-brokensep pkgconfig update-rc.d

# the configure script is hand-crafted, it rejects some of the usual
# configure arguments
do_configure () {
    ${S}/configure \
		--prefix=${prefix} \
		--bindir=${bindir} \
		--localedir=${datadir}/locale \
		--sysconfdir=${sysconfdir} \
		--cross-compile
}

INITSCRIPT_NAME = "ushare"
INITSCRIPT_PARAMS = "defaults 20"

FILES:${PN} += "${sysconfdir}/ushare.conf "

do_install:append() {
	install -D -m 0755 ${UNPACKDIR}/init ${D}${sysconfdir}/init.d/ushare
	install -D -m 0644 ${UNPACKDIR}/ushare.conf ${D}${sysconfdir}/ushare.conf
}

INSANE_SKIP:${PN} += "already-stripped"
