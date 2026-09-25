FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"

PV = "1.28.7"

SRC_URI[sha256sum] = "787329b2c5758e228a71d926a6dcf960bceaacca3cadd63874ba665dfcda013e"

SRC_URI:append = " file://0001-revert-use-new-gst-adapter-get-buffer.patch \
		file://0001-input-selector-release-active-sinkpad-lock-across-p.patch \
"

LDFLAGS:append:mipsarch = " -latomic"
