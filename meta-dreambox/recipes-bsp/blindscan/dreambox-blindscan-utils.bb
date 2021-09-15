SUMMARY = "Utilities needed to do transponder blindscan with dreambox dvb receivers"
LICENSE = "CLOSED"

COMPATIBLE_MACHINE = "^(dm500hd|dm800|dm800se)$"

PROVIDES += "virtual/blindscan-dvbs virtual/blindscan-dvbc"
RPROVIDES_${PN} += "virtual/blindscan-dvbs virtual/blindscan-dvbc"

DEPENDS = "ncurses"

PV = "1.12"
PV_dm800 = "1.9"

DREAMBOXURL = "http://dreamboxupdate.com/download/opendreambox"

SRC_URI = "${DREAMBOXURL}/2.2.0/blindscan-utils/${PV}/${DEFAULTTUNE}/2acb58192434f308bfed6879c51d5d6e/blindscan-utils_${PV}_${DEFAULTTUNE}.tar.xz;name=${DEFAULTTUNE}-dora"

SRC_URI_dm800 = "${DREAMBOXURL}/2.0.0/blindscan-utils/blindscan-utils_${PV}_${DEFAULTTUNE}.tar.bz2;name=${DEFAULTTUNE}-denzil"

S = "${WORKDIR}/blindscan-utils_${PV}_${DEFAULTTUNE}"

PACKAGES = "${PN}"

SRC_URI[mips32el-dora.md5sum] = "2acb58192434f308bfed6879c51d5d6e"
SRC_URI[mips32el-dora.sha256sum] = "afe56c1d222c4d6d33509208116628c30f88916bda7a19e5c749dcbc914d6020"

SRC_URI[mips32el-nf-denzil.md5sum] = "143cb7253132af1ecd3aafa3679c6109"
SRC_URI[mips32el-nf-denzil.sha256sum] = "53d2760e3aa19eab6e19edabe8b9dd840c693ca30c43495904241e52fd40ea32"

do_install() {
    cp -fr * ${D}
}

INHIBIT_PACKAGE_STRIP = "1"
