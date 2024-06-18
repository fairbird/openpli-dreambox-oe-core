SUMMARY = "Glamour Aura FHD skin for new generation STBs"
MAINTAINER = "MCelliotG"
require conf/license/license-gplv2.inc
require classes/python3-compileall.inc

inherit allarch gitpkgv

PV = "14.x+git"
PKGV = "14.x+git${GITPKGV}"
VER = "14.x"

RRECOMMENDS:${PN} = "enigma2-plugin-extensions-weathermsn enigma2-plugin-extensions-bitrate"

SRC_URI = "git://github.com/MCelliotG/GlamourAuraFHD-ATV-skin.git;protocol=https;branch=master"

FILES:${PN} = "/usr/*"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/usr/share/enigma2
    cp -rp ${S}/usr ${D}/
    chmod -R a+rX ${D}/usr/share/enigma2/
}

pkg_postinst:${PN} () {
#!/bin/sh
if [ -f /tmp/GlamourAuraFHD-ATV/skin.xml ]; then
    rm -rf /usr/share/enigma2/GlamourAuraFHD-ATV/
    mv /tmp/GlamourAuraFHD-ATV /usr/share/enigma2/
fi
echo "                                                                        "
echo "Glamour Aura FHD ATV skin is now successfully installed on your receiver"
echo "                       Enjoy!!!                                         "
}

pkg_postrm:${PN} () {
#!/bin/sh
rm -rf /usr/share/enigma2/GlamourAuraFHD-ATV
rm -rf /usr/lib/enigma2/python/Components/Converter/Glam*
rm -rf /usr/lib/enigma2/python/Components/Renderer/Glam*
echo "                                                                      "
echo "Glamour Aura FHD skin was successfully removed from your receiver."
echo "                                                                      "
}

pkg_preinst:${PN} () {
#!/bin/sh
echo "                        *******                             "
echo "                  ******       *****                        "
echo "             ****                   ****                    "
echo "          ***                            ***                "
echo "        **      GLAMOUR AURA FHD SKIN       **              "
echo "                a skin by MCelliotG                         "
echo "                                                            "
echo "                                                            "
echo "        *********    DISCLAIMER      *********              "
echo "Glamour Aura FHD skin requires a minimal CPU @ 1000 Mhz."
echo "Glamour Aura FHD is NOT guaranteed to work on slower or older receivers."
echo "                                             "
echo "                                             "
echo "                                             "
echo "                                             "
echo "Checking if a previous version of Glamour Aura FHD skin is installed..."
if [ -f /usr/share/enigma2/GlamourAuraFHD-ATV/skin.xml ]; then
    cp -R /usr/share/enigma2/GlamourAuraFHD-ATV/ /tmp
    rm -rf /usr/share/enigma2/GlamourAuraFHD-ATV
    rm -rf /usr/lib/enigma2/python/Components/Converter/Glam*
    rm -rf /usr/lib/enigma2/python/Components/Renderer/Glam*
    echo "                                               "
    echo "Previous Glamour Aura FHD ATV skin installation"
    echo "    was found and removed successfully!        "
    echo "                                               "
fi
echo "                                                   "
echo "Glamour Aura FHD skin is now being installed..."
echo "                                                   "
}

pkg_prerm:${PN} () {
#!/bin/sh
echo "                                                                  "
echo "Glamour Aura FHD ATV skin is now being removed from your receiver."
echo "                                                                  "
}

do_package_qa[noexec] = "1"
