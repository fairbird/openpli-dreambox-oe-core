DEPENDS:remove = "gnutls"
DEPENDS += "openssl"

PROVIDES =+ " librtmp librtmp1"

SRC_URI += " \
	file://ksv.patch \
	file://fix-build-openssl110.patch \
	file://iptvplayer_release.patch \
"

EXTRA_OEMAKE = " \
	CC='${CC}' LD='${LD} ${STAGING_LIBDIR}' XCFLAGS='${CFLAGS}' XLDFLAGS='${LDFLAGS}' \
	SYS=posix INC=-I=/usr/include DESTDIR=${D} \
	prefix=${prefix} libdir=${libdir} incdir=${includedir}/librtmp bindir=${bindir} mandir=${mandir}"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

CFLAGS += "-Wno-error=incompatible-pointer-types"
