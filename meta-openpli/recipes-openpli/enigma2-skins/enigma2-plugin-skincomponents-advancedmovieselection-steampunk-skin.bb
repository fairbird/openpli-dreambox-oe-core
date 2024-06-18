SUMMARY = "AdvancedMovieSelection-Steampunk-Skin-by-stein17"
MAINTAINER = "stein17"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

inherit gitpkgv
PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/stein17/Skins-for-Plugins-by-stein17.git;branch=master;protocol=https"

S = "${WORKDIR}/git/Steampunk-HD-Skin-for-AMS-by-stein17"

FILES:${PN} = "usr/"

pkg_postinst:${PN} () {
#!/bin/sh

echo "                                                                                "
echo "                                                                                "
echo "                                                                                "
echo "                                                                                "
echo "                                                                                "
echo "                                                                                "
echo "                                                                                "
echo "                                                                                "
echo "                                                                                "
echo "...Steampunk HD Skin for AdvancedMovieSelection by stein17 successful installed."
echo "                                                                                "
echo "                                                                                "
echo "                                                                                "
exit 0
}

pkg_postrm:${PN} () {
#!/bin/sh

mv /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/skin/skin.xml_orig /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/skin/skin.xml
mv /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/images/nocover_de.png_orig /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/images/nocover_de.png
mv /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/images/starsbar_empty.png_orig /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/images/starsbar_empty.png
mv /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/images/starsbar_filled.png_orig /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/images/starsbar_filled.png

echo "syncing disk"
sync
echo ""
echo ""
echo "*********************************************************"
echo "* Steampunk HD Skin for AdvancedMovieSelection by stein17 "
echo "*********************************************************"
echo ""
echo ""
echo ""
echo "Steampunk HD Skin for AdvancedMovieSelection by stein17 successfully removed!"
echo ""
echo ""
echo "GUI restart."
echo ""
echo ""
echo ""
echo "Steampunk HD Skin for AdvancedMovieSelection by stein17 wurde erfolgreich entfernt!"
echo ""
echo ""
echo ""
echo "GUI Neustart."
echo ""
echo ""
echo ""
exit 0
}

pkg_preinst:${PN} () {
#!/bin/sh

mv /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/skin/skin.xml /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/skin/skin.xml_orig
mv /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/images/nocover_de.png /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/images/nocover_de.png_orig
mv /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/images/starsbar_empty.png /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/images/starsbar_empty.png_orig
mv /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/images/starsbar_filled.png /usr/lib/enigma2/python/Plugins/Extensions/AdvancedMovieSelection/images/starsbar_filled.png_orig

echo "                                                                                           "
echo "                                                                                           "
echo "                                                                                           "
echo "                                                                                           "
echo "                                                                                           "
echo "                                                                                           "
echo "                                                                                           "
echo "  Steampunk HD Skin for AdvancedMovieSelection by stein17 is now being installed... "
echo "                                                                                           "
echo "                                                                                           "
echo "                                                                                           "
exit 0
}

pkg_prerm:${PN} () {
#!/bin/sh
echo "                                                                                                  "
echo "Steampunk HD Skin for AdvancedMovieSelection by stein17 is now being removed from your receiver..."
echo "                                                                                                  "
exit 0
}

do_populate_sysroot[noexec] = "1"
do_package_qa[noexec] = "1"
