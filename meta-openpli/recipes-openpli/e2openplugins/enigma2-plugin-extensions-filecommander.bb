MODULE = "FileCommander"
DESCRIPTION = "File manager based on OpenATV one"

require openplugins.inc
require openplugins-distutils.inc

SRC_URI:append = " file://use-setuptools-instead-of-distutils.patch \
                   file://set-list-before-update.patch \
"
