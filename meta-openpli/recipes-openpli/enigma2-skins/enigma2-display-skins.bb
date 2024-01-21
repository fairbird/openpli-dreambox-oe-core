SUMMARY = "Display Skins for Enigma2"
MAINTAINER = "oe-aliance"
PACKAGES = "${PN}-meta ${PN}"
PACKAGES_DYNAMIC = "enigma2-plugin-display-*"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://README.md;startline=1;endline=6;md5=c3aa97ff8b8db3a19449f03d81db3654"

inherit gitpkgv

PACKAGE_ARCH = "${MACHINE_ARCH}"
PV = "git"
PKGV = "git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/fairbird/enigma2-display-skins.git;protocol=https;branch=master"

# note that enigma2-skins is just an empty package to satisfy silly dependencies.
ALLOW_EMPTY:${PN} = "1"
FILES:${PN} = "/usr/share/enigma2/display"
FILES:${PN}-meta = "${datadir}/meta"
RDEPENDS:${PN}-meta = ""

inherit autotools-brokensep

S = "${WORKDIR}/git"

EXTRA_OECONF += "\
    ${@bb.utils.contains("MACHINE_FEATURES", "textlcd", "--with-textlcd" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "colorlcd", "--with-colorlcd" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "colorlcd128", "--with-colorlcd128" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "colorlcd240", "--with-colorlcd240" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "colorlcd390", "--with-colorlcd390" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "colorlcd400", "--with-colorlcd400" , "", d)} \
    "

python populate_packages:prepend () {
    if bb.data.expand('${REL_MINOR}', d) != "4":
        enigma2_skindir = bb.data.expand('${datadir}/enigma2/display', d)
        do_split_packages(d, enigma2_skindir, '(.*?)/.*', 'enigma2-plugin-display-%s', 'Enigma2 Display Skin: %s', recursive=True, match_path=True, prepend=True)
}
