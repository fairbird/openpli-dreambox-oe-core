SUMMARY = "MediaPlayer 2 for Enigma2"
DESCRIPTION = "mediaplayer plugin with added support for subssupport plugin for enhanced subtitles support."
HOMEPAGE = "https://github.com/oe-mirrors/mediaplayer2.git"
AUTHOR = "Maroš Ondrášek <mx3ldev@gmail.com> and OE-A"
LICENSE = "Proprietary"
require conf/license/license-gplv2.inc
require classes/python3-compileall.inc

inherit gitpkgv setuptools3-openplugins gettext

RDEPENDS:${PN} = "python3-xmlrpc python3-compression python3-codecs python3-difflib unrar enigma2-plugin-extensions-subssupport"

inherit gitpkgv
PV = "0.8+git"
PKGV = "0.8+git${GITPKGV}"

SRC_URI = "git://github.com/oe-mirrors/mediaplayer2.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

python populate_packages:prepend() {
    e2_pdir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, e2_pdir, '^(\w+/\w+)/.*\/.*\.po$', 'enigma2-plugin-%s-po', '%s (translations)', recursive=True, match_path=True, prepend=True)
}


