MODULE = "Foreca"
DESCRIPTION = "Weather forecast for the upcoming 10 days"
RDEPENDS:${PN} = "python3-html"

require openplugins.inc
require openplugins-distutils.inc

SRC_URI:append = " file://use-setuptools-instead-of-distutils.patch"

FILES:${PN} += "${sysconfdir}/enigma2/Foreca"
CONFFILES:${PN} = "${sysconfdir}/enigma2/Foreca/City.cfg ${sysconfdir}/enigma2/Foreca/Filter.cfg"

INSANE_SKIP:${PN} = "dev-so installed-vs-shipped"
