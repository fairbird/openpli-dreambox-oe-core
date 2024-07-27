MODULE = "FileCommander"
DESCRIPTION = "File manager based on OpenATV one"

require openplugins.inc
inherit setuptools3-openplugins

SRC_URI:append = " file://use-setuptools-instead-of-distutils.patch \
                   file://set-list-before-update.patch \
                   file://update-extensions-and-add-Type-of-edit.patch \
"
