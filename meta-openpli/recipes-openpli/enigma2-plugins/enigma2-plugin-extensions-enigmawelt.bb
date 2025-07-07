SUMMARY = "The biggest DreamOS/Enigma2 Video Blog"
MAINTAINER = "enigmawelt jbleyel CommanderData2338"
HOMEPAGE = "https://enigmawelt.de"
SECTION = "base"

require conf/license/license-gplv2.inc

inherit allarch gitpkgv python3-compileall

PV = "git"
PKGV = "${GITPKGVTAG}"

SRC_URI = "git://github.com/enigmawelt/enigmawelt.de.git;protocol=https;branch=main"

S = "${UNPACKDIR}/git"

FILES:${PN} = "${libdir}"

do_install() {
    install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/Enigmawelt
    cp -rf ${S}/src/* ${D}${libdir}/enigma2/python/Plugins/Extensions/Enigmawelt/
}

pkg_postrm:${PN}() {
#!/bin/sh
rm -r ${libdir}/enigma2/python/Plugins/Extensions/Enigmawelt 2>/dev/null
exit 0
}
