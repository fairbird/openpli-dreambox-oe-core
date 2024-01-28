MODULE = "SystemTools"
DESCRIPTION = "System Tools for enigma2 stb"

require openplugins.inc
inherit setuptools3-openplugins

SRC_URI:append = " file://use-setuptools-instead-of-distutils.patch"
