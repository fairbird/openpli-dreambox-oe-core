SUMMARY = "LC_TIME locale support"
LICENSE = "CLOSED"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "OpenPli team"

SRC_URI = "file://lctimelocales.tar.gz file://locale.alias file://SYS_LC_MESSAGES file://locale.sh"

S = "${WORKDIR}/locales"

inherit allarch

LOCALEDIR = "${libdir}/locale"
LOCALEDIR2 = "${datadir}/locale"

LANGUAGES = "ar_AE bg_BG ca_AD cs_CZ da_DK de_DE el_GR es_ES en_GB et_EE fa_IR fi_FI fr_FR fy_NL \
	gl_ES he_IL hr_HR hu_HU id_ID is_IS it_IT ku_TR lt_LT lv_LV mk_MK nb_NO nl_NL pl_PL \
	pt_BR pt_PT ro_RO ru_RU sk_SK sl_SI sr_RS sv_SE th_TH tr_TR uk_UA vi_VN zh_CN zh_HK C.UTF-8"

RPROVIDES:${PN}  = "${@" ".join(map(lambda s: "virtual-locale-%s" % s, d.getVar('LANGUAGES').split())).lower().replace('_','-')}"
RPROVIDES:${PN} += "${@" ".join("virtual-locale-%s" % p.split('_')[0] for p in d.getVar('LANGUAGES').split())}"
RPROVIDES:${PN} += "${@" ".join(map(lambda s: "locale-base-%s" % s, d.getVar('LANGUAGES').split())).lower().replace('_','-')}"
RCONFLICTS:${PN} = "${@" ".join(map(lambda s: "locale-base-%s" % s, d.getVar('LANGUAGES').split())).lower().replace('_','-')}"
RREPLACES:${PN}  = "${@" ".join(map(lambda s: "locale-base-%s" % s, d.getVar('LANGUAGES').split())).lower().replace('_','-')}"

do_install() {
	install -d ${D}${sysconfdir}/profile.d
	install -m 0644 ${UNPACKDIR}/locale.sh ${D}${sysconfdir}/profile.d/locale.sh
	install -d ${D}${LOCALEDIR2}
	install ${UNPACKDIR}/locale.alias ${D}${LOCALEDIR2}

	install -d ${D}${LOCALEDIR}
	cp -r --preserve=mode,links ${S}/* ${D}/${LOCALEDIR}

	install -d ${D}${LOCALEDIR}/fake/LC_MESSAGES
	install ${UNPACKDIR}/SYS_LC_MESSAGES ${D}${LOCALEDIR}/fake/LC_MESSAGES/

	for lang in ${LANGUAGES}; do
		[ "$lang" = "en_GB" -o "C.UTF-8" ] && continue  # Skip the folders
		ln -s ../fake/LC_MESSAGES ${D}${LOCALEDIR}/${lang}/LC_MESSAGES
	done

	ln -s en_GB ${D}${LOCALEDIR}/en_EN
	ln -s en_GB ${D}${LOCALEDIR}/en_AU
	ln -s nb_NO ${D}${LOCALEDIR}/no_NO
	ln -s nb_NO ${D}${LOCALEDIR}/nn_NO
	ln -s sr_RS ${D}${LOCALEDIR}/sr_YU
}

FILES:${PN} = "${LOCALEDIR} ${LOCALEDIR2} ${sysconfdir}/profile.d"
