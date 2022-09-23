MODULE = "FileCommander"
DESCRIPTION = "File manager based on OpenATV one"

require conf/license/license-gplv2.inc

require openplugins-replace-pli.inc

require openplugins-distutils.inc

SRC_URI = "git://github.com/Hains/e2openplugin-FileCommander.git;protocol=https;branch=python3 file://use-setuptools-instead-of-distutils.patch"
