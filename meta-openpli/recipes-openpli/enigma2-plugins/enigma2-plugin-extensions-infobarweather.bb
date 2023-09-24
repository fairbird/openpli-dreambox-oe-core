DESCRIPTION = "Infobar Weather plugin"
MAINTAINER = "scriptmelvin"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

inherit gitpkgv setuptools-openplugins gettext

PV = "2.0+git"
PKGV = "2.0+git${GITPKGV}"

SRC_URI = "git://github.com/scriptmelvin/enigma2-plugin-extensions-infobarweather.git;protocol=https;branch=main"

S="${WORKDIR}/git"
