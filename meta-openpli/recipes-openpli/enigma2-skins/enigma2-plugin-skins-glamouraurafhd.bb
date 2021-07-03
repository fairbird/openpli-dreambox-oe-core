DESCRIPTION = "Glamour Aura FHD skin by MCelliot_g for OpenPLI and OpenPLI based images."
MAINTAINER = "MCelliot_g"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

RRECOMMENDS_${PN} = "enigma2-plugin-extensions-weathermsn"

SRC_URI = "git://github.com/MCelliotG/GlamourAuraFHD-skin.git;protocol=git"

FILES_${PN} = "${prefix}"

S = "${WORKDIR}/git"

require skin-data.inc
require skin-python.inc
