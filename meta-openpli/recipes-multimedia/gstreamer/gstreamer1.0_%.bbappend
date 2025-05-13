FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"

PV = "1.26.1"

SRC_URI[sha256sum] = "30a4c4a5e48345583eb596aa265d0f53c0feb93011d93a6aaa70dd6e3c519dc4"

SRC_URI:append = " file://0001-revert-use-new-gst-adapter-get-buffer.patch"
SRC_URI:remove = "file://0001-Fix-atomic-64-issue-on-armv5.patch"

LDFLAGS:append:mipsarch = " -latomic"
