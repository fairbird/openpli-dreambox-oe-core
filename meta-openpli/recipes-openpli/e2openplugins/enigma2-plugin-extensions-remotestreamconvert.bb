MODULE = "RemoteChannelStreamConverter"
DESCRIPTION = "Fetch channels from remote bouquets and make them available locally"

RDEPENDS:${PN} = "python3-shell"

require openplugins.inc
require openplugins-distutils.inc

BRANCH = "master"
