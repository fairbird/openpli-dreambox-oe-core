SUMMARY = "Cloudflare Public DNS configuration"
HOMEPAGE = "https://cloudflare-dns.com/"
LICENSE = "CLOSED"

SRC_URI = "file://resolv.conf"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

do_install() {
	install -d ${D}${sysconfdir}
	install -m 644 ${UNPACKDIR}/resolv.conf ${D}${sysconfdir}/resolv.conf
}
