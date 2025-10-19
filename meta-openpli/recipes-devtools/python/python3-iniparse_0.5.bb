DESCRIPTION = "iniparse is a INI parser for Python"
HOMEPAGE = "http://code.google.com/p/iniparse/"
SECTION = "devel/python"
PRIORITY = "optional"

require conf/license/license-gplv2.inc

SRC_URI = "https://files.pythonhosted.org/packages/4c/9a/02beaf11fc9ea7829d3a9041536934cd03990e09c359724f99ee6bd2b41b/iniparse-0.5.tar.gz"

SRC_URI[md5sum] = "2054bab923df21107652d009f2373789"
SRC_URI[sha256sum] = "932e5239d526e7acb504017bb707be67019ac428a6932368e6851691093aa842"

S = "${UNPACKDIR}/iniparse-${PV}"

inherit setuptools3
