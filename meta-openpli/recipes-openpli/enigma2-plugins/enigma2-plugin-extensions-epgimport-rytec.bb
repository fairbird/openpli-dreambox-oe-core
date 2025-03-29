DESCRIPTION = "Rytec's XMLTV sources and channels for the EPGImporter"
MAINTAINER = "Rytec forum @ forums.openpli.org"

require conf/license/openpli-gplv2.inc

inherit allarch python3-compileall

PV = "20250318"
SRC_URI = "http://rytecepg.wanwizard.eu/rytec.sources.xml.${PV}.gz"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

RREPLACES:${PN} = "enigma2-plugin-extensions-xmltvimport-rytec"
RCONFLICTS:${PN} = "enigma2-plugin-extensions-xmltvimport-rytec"

PACKAGES = "${PN}"

FILES:${PN} = "${sysconfdir}/epgimport"

do_install() {
	install -d ${D}${sysconfdir}/epgimport
	install -m 644 ${S}/rytec.sources.xml.${PV} ${D}${sysconfdir}/epgimport/rytec.sources.xml
}

SRC_URI[sha256sum] = "f9135125fbd1bebaeea5b89a158921969bf623a6562ed7ca871b67b3c9e414a0"
