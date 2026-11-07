DESCRIPTION = "Oscam Streamrelay whitelist"
MAINTAINER = "E2OpenPlugins"
LICENSE = "LicenseRef-LICENSE-CLOSED"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/meta-openpli/licenses/LICENSE-CLOSED;md5=2d5b03b35d4612637d67724b35738dd7"

PV = "2.1+git${SRCPV}"
PKGV = "2.1+git${GITPKGV}"

SRC_ORIGIN ?= "git://github.com/E2OpenPlugins/oscam-whitelist.git;protocol=https;branch=main"
SRC_URI := "${SRC_ORIGIN} "

inherit allarch gitpkgv

RCONFLICTS:${PN} = "enigma2-plugins-softcams-oscam-whitelist"
RREPLACES:${PN} = "enigma2-plugins-softcams-oscam-whitelist"

do_install () {
	install -d ${D}${sysconfdir}/enigma2/
	if [ -f ${D}${sysconfdir}/enigma2/whitelist_streamrelay ]; then
		rm -f ${D}${sysconfdir}/enigma2/whitelist_streamrelay
	fi
	cp -r ${S}/whitelist_streamrelay ${D}${sysconfdir}/enigma2
}
