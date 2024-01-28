MODULE = "NfsServer"
DESCRIPTION = "NFS server configuration"

RDEPENDS:${PN} = "nfs-utils"

require openplugins.inc
require openplugins-distutils.inc
