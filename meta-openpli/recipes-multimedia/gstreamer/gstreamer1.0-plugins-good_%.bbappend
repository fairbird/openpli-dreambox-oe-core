FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"

PV = "1.28.7"

SRC_URI[sha256sum] = "87256969c82cf3bc8574301f3e7044a90de0ac500a5a27d8ba38c4dde894dd8b"

SRC_URI:append = " \
           file://0001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch \
           file://0002-Revert-souphttpsrc-Always-use-the-content-decoder.patch \
"

PACKAGECONFIG:remove = "soup3"

RDEPENDS:${PN}-soup:remove = "${MLPREFIX}libsoup"
RDEPENDS:${PN}-soup += "${MLPREFIX}${@bb.utils.contains('PACKAGECONFIG', 'soup2', 'libsoup-2.4', 'libsoup', d)}"

PACKAGECONFIG[soup2] = "-Dsoup=enabled,-Dsoup=disabled,libsoup-2.4"

PACKAGECONFIG:append = " \
    soup2 \
    ${@bb.utils.contains('MACHINE_FEATURES', 'novp9', '', 'vpx',d)} \
    wavpack gudev amrnb amrwb \
"

PACKAGECONFIG_CONFARGS:remove = "-Dsoup=disabled"
EXTRA_OEMESON:append = " -Dsoup=enabled"
