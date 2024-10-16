
KODIADDONNAME ?= "${PN}"

DEPENDS += "zip-native \
            p8platform \
            kodi-platform \
          "

inherit cmake pkgconfig gettext

ASNEEDED = ""

EXTRA_OECMAKE = " \
	  -DADDONS_TO_BUILD=inputstream.adaptive \
	  -DADDON_SRC_PREFIX=${UNPACKDIR}/git \
	  -DCMAKE_BUILD_TYPE=Debug \
	  -DCMAKE_INSTALL_PREFIX=${datadir}/kodi/addons \
          -DKODI_INCLUDE_DIR=${STAGING_INCDIR}/kodi \
          -DCMAKE_MODULE_PATH='${STAGING_DIR_HOST}${libdir}/kodi;${STAGING_DIR_HOST}${datadir}/kodi/cmake' \
          -DCMAKE_PREFIX_PATH=${STAGING_DIR_HOST}${prefix} \
          -DPACKAGE_ZIP=1 \
        "

# Make zip package for manual installation
do_install:append() {
	install -d ${D}${datadir}/kodi/addons/packages/
	( cd ${D}${datadir}/kodi/addons
	  zip -r ${D}${datadir}/kodi/addons/packages/${KODIADDONNAME}-${PV}.zip ${KODIADDONNAME} -x '*.debug*' )
}

# Doesn't get added automagically, dlopen()?
RDEPENDS:${PN} = "libkodiplatform"

INSANE_SKIP:${PN} = "dev-so"
FILES:${PN} += "${datadir}/kodi"
FILES:${PN}-dbg += "${datadir}/kodi/addons/*/.debug/"
