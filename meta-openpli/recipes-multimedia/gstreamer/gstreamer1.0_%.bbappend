FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"

SRC_URI:append = " file://0001-revert-use-new-gst-adapter-get-buffer.patch \
		file://0001-input-selector-release-active-sinkpad-lock-across-p.patch \
		file://0002-input-selector-reconfigure-the-other-pads-after-the-active-one.patch
"

LDFLAGS:append:mipsarch = " -latomic"
