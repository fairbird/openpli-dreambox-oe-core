SUMMARY = "${DATA_LIST} for enigma2"

require conf/license/openvision-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/openvision-xml.git;protocol=git"

FILES_${PN} = "/"

S = "${WORKDIR}/git"

DATA_LIST = "iso-639-3.pck"

do_install() {
    install -d ${D}${datadir}/enigma2/

    for i in ${DATA_LIST}; do
        install -m 0644 ${S}/data/$i ${D}${datadir}/enigma2/$i
    done;
}
