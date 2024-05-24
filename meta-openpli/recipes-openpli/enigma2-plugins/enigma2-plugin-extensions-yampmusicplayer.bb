DESCRIPTION = "Music Player with Artist-Art Background"
HOMEPAGE = "https://github.com/oe-mirrors/yampmusicplayer"
MAINTAINER = "oe-a"
PRIORITY = "optional"
require conf/license/license-gplv2.inc
require classes/python3-compileall.inc

RDEPENDS:${PN} = "python3-sqlite3 python3-tinytag python3-beautifulsoup4"

inherit gittag allarch setuptools3-openplugins gettext

PV = "git"
PKGV = "${GITPKGVTAG}"

SRC_URI = "git://github.com/oe-mirrors/yampmusicplayer.git;protocol=https;branch=main \
	file://setuptools-62.patch \
"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${sysconfdir}/enigma2
    echo 1234567890abcdef7890123456789012 > ${D}${sysconfdir}/enigma2/YampFanarttvPersonalApi.key
}

FILES:${PN} = "${sysconfdir} ${libdir}"

CONFFILES:${PN} = "${sysconfdir}/enigma2/YampFanarttvPersonalApi.key"
