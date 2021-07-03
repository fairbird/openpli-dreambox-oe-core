SUMMARY = "Cloudflare Public DNS configuration"
HOMEPAGE = "https://cloudflare-dns.com/"
LICENSE = "CLOSED"

SRC_URI = "file://resolv.conf"

do_install() {
	install -d ${D}${sysconfdir}
	install -m 644 ${WORKDIR}/resolv.conf ${D}${sysconfdir}/resolv.conf
}
