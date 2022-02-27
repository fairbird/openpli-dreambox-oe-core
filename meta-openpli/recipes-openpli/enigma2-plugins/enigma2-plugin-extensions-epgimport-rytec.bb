DESCRIPTION = "Rytec's XMLTV sources and channels for the EPGImporter"
MAINTAINER = "Rytec forum @ forums.openpli.org"

require conf/license/openpli-gplv2.inc
require classes/python3-compileall.inc

inherit allarch

PV = "20210910"
SRC_URI = "http://rytecepg.wanwizard.eu/rytec.sources.xml.${PV}.gz"

S = "${WORKDIR}"

RREPLACES:${PN} = "enigma2-plugin-extensions-xmltvimport-rytec"
RCONFLICTS:${PN} = "enigma2-plugin-extensions-xmltvimport-rytec"

PACKAGES = "${PN}"

FILES:${PN} = "${sysconfdir}/epgimport"

do_install() {
	install -d ${D}${sysconfdir}/epgimport
	install -m 644 ${S}/rytec.sources.xml.${PV} ${D}${sysconfdir}/epgimport/rytec.sources.xml
}

SRC_URI[sha256sum] = "50504ddbbe42b9fe8b7095ec58e3d070de290695e7b6183ebc43bd0a2240ffc4"
