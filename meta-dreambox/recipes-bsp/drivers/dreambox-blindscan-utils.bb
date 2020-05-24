SUMMARY = "Utilities needed to do transponder blindscan with dreambox dvb receivers"
LICENSE = "CLOSED"

PROVIDES += "virtual/blindscan-dvbs virtual/blindscan-dvbc"
RPROVIDES_${PN} += "virtual/blindscan-dvbs virtual/blindscan-dvbc"

DEPENDS = "ncurses"
INSANE_SKIP_${PN} += "already-stripped"

PV = "1.12"

SRC_URI += "http://dreamboxupdate.com/download/opendreambox/2.5.0/blindscan-utils/${PV}/${DEFAULTTUNE}/9e93783a6ac4611bb683d0b36fc44a87/blindscan-utils_${PV}_${DEFAULTTUNE}.tar.xz;name=${DEFAULTTUNE}-krogoth"

S = "${WORKDIR}/blindscan-utils_${PV}_${DEFAULTTUNE}"

PACKAGES = "${PN}"

SRC_URI[cortexa15hf-neon-vfpv4-krogoth.md5sum] = "9e93783a6ac4611bb683d0b36fc44a87"
SRC_URI[cortexa15hf-neon-vfpv4-krogoth.sha256sum] = "ff4de20d84cf6aef48270684cb78764f7ee9d13d92fab42217f378be06047d1f"

do_install() {
    cp -r * ${D}
}

INHIBIT_PACKAGE_STRIP = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"
