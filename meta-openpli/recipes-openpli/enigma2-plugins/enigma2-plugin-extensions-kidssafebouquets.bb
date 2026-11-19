DESCRIPTION = "Enigma2 family-safety bouquet cleaner. Removes Adult / Erotic / XXX bouquets, complete sections and matching channels, with Strict Kids Mode, backup and restore."
MAINTAINER = "dorinelu"
SECTION = "extra"
PRIORITY = "optional"
HOMEPAGE = "https://github.com/dorinelu/KidsSafeBouquets"

require conf/license/license-gplv2.inc

PN = "enigma2-plugin-extensions-kidssafebouquets"

SRC_URI = "git://github.com/dorinelu/KidsSafeBouquets;protocol=https;branch=main"

inherit gittag python3-compileall

SRCREV = "${AUTOREV}"

PV = "git"
PKGV = "${GITPKGVTAG}"

PACKAGE_ARCH = "all"

RDEPENDS:${PN} = "enigma2"

PLUGIN_DIR = "${libdir}/enigma2/python/Plugins/Extensions/KidsSafeBouquets"

FILES:${PN} = "${PLUGIN_DIR}/"


do_install() {
    install -d ${D}${PLUGIN_DIR}

    cp -r ${S}/usr/lib/enigma2/python/Plugins/Extensions/KidsSafeBouquets/. ${D}${PLUGIN_DIR}/

    python3 -m compileall -o2 -b ${D}${PLUGIN_DIR} -d /
}


python do_package:prepend() {
    import os

    control_dir = os.path.join(d.getVar("S"), "CONTROL")
    pn = d.getVar("PN")

    for script in ("postinst", "postrm"):
        script_path = os.path.join(control_dir, script)

        if not os.path.isfile(script_path):
            bb.fatal("Missing CONTROL script: %s" % script_path)

        with open(script_path, "r") as f:
            d.setVar("pkg_%s:%s" % (script, pn), f.read())
}
