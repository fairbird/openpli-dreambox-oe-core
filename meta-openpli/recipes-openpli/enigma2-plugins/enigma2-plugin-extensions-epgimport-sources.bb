DESCRIPTION = "XMLTV sources and channels for the EPGImporter"
MAINTAINER = "Doglover @ https://forums.openpli.org/forum/52-en-rytec-xmltv-and-epg-support/"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_ORIGIN ?= "git://github.com/doglover3920/EPGimport-Sources.git;protocol=https;branch=main"
SRC_URI := "${SRC_ORIGIN} "

S = "${UNPACKDIR}/git"

RREPLACES:${PN} = "enigma2-plugin-extensions-xmltvimport-rytec enigma2-plugin-extensions-epgimport-rytec"
RCONFLICTS:${PN} = "enigma2-plugin-extensions-xmltvimport-rytec enigma2-plugin-extensions-epgimport-rytec"

PACKAGES = "${PN}"

FILES:${PN} = "${sysconfdir}/epgimport"

do_install() {
	install -d ${D}${sysconfdir}/epgimport
	install -m 644 ${S}/rytec.sources.xml ${D}${sysconfdir}/epgimport/rytec.sources.xml
	install -m 644 ${S}/turkish.sources.xml ${D}${sysconfdir}/epgimport/turkish.sources.xml
	install -m 644 ${S}/spainKoala.sources.xml ${D}${sysconfdir}/epgimport/spainKoala.sources.xml
	install -m 644 ${S}/polandAzman.sources.xml ${D}${sysconfdir}/epgimport/polandAzman.sources.xml
}
