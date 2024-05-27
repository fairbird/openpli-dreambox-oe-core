FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"
SRC_URI:append = " file://0001-revert-use-new-gst-adapter-get-buffer.patch"

PV = "1.24.3"

SRC_URI[md5sum] = "5372d80f070ea638973cd7bf647cb9a4"
SRC_URI[sha256sum] = "1225ef4a329fae1cadc5ec727dab249ad567e8072879493561ceb91ed34aa414"
