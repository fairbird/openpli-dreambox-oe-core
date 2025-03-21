FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"

PV = "1.26.0"

SRC_URI[sha256sum] = "1b2ee4028010c25b776effa7c396c7e3e1861b60b9417e416f4914abcdff279f"

SRC_URI:append = " file://0001-revert-use-new-gst-adapter-get-buffer.patch"
