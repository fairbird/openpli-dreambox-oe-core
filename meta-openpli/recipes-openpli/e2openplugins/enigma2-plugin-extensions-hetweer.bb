MODULE = "HetWeer"
DESCRIPTION = "HetWeer plugin"

require openplugins.inc
inherit setuptools3-openplugins

PLUGINPATH = "${libdir}/enigma2/python/Plugins/Extensions/${MODULE}"
do_install() {
        install -d ${D}${PLUGINPATH}/Images
        cp -r ${S}/plugin/* ${D}${PLUGINPATH}
        chmod a+rX ${D}${PLUGINPATH}
}

FILES:${PN} = "${PLUGINPATH}"

SRC_URI:append = " file://replace-distutils-with-setuptools.patch"
