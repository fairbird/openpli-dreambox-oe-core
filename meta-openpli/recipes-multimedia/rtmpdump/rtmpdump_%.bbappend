DEPENDS:remove = "gnutls"
DEPENDS += "openssl"

PROVIDES =+ " librtmp librtmp1"

do_configure() {
}
 
EXTRA_OEMAKE = " \
	CC='${CC}' LD='${LD} ${STAGING_LIBDIR}' XCFLAGS='${CFLAGS}' XLDFLAGS='${LDFLAGS}' \
	SYS=posix INC=-I${STAGING_INCDIR} DESTDIR=${D} \
	prefix=${prefix} libdir=${libdir} incdir=${includedir}/librtmp bindir=${bindir} mandir=${mandir}"
