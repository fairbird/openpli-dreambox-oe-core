MODULE = "PPanel"
DESCRIPTION = "PPanel"

require openplugins.inc
inherit setuptools3-openplugins

PACKAGES =+ "${PN}-example"

FILES:${PN} = "${prefix}"
FILES:${PN}-example = "/etc/ppanel/PPanel_tutorial.xml"

SRC_URI:append = " file://use-setuptools-instead-of-distutils.patch"
