MODULE = "NewsReader"
DESCRIPTION = "RSS reader"

require openplugins.inc
inherit setuptools3-openplugins

FILES:${PN} += "${sysconfdir}/feeds.xml"
CONFFILES:${PN} = "${sysconfdir}/feeds.xml"
