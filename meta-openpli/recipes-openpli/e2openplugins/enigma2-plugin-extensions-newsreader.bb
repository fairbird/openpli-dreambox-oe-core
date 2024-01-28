MODULE = "NewsReader"
DESCRIPTION = "RSS reader"

require openplugins.inc
require openplugins-distutils.inc

FILES:${PN} += "${sysconfdir}/feeds.xml"
CONFFILES:${PN} = "${sysconfdir}/feeds.xml"
