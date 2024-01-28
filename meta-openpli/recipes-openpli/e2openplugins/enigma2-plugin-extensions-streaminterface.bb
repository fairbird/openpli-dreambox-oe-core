MODULE = "StreamInterface"
DESCRIPTION = "Stream webinterface on port 40080"

RDEPENDS:${PN} = "python3-twisted-web"

require openplugins.inc
require openplugins-distutils.inc
