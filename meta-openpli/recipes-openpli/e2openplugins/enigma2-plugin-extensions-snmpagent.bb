MODULE = "SnmpAgent"
DESCRIPTION = "SNMP Agent"

RDEPENDS:${PN} = "enigma2-plugin-extensions-bitrate twistedsnmp"

require openplugins.inc
require openplugins-distutils.inc
