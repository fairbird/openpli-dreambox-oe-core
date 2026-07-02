FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"

SRC_URI:append = " \
           file://0001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch \
           file://0002-Revert-souphttpsrc-Always-use-the-content-decoder.patch \
"

PACKAGECONFIG:append = " \
	${@bb.utils.contains('MACHINE_FEATURES', 'novp9', '', 'vpx',d)} \
	wavpack gudev amrnb amrwb \
"
