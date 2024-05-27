FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_NO_LOCALE = "1"
PR = "r2"

SRC_URI:append = " \
           file://0001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch \
           file://0002-Revert-souphttpsrc-Always-use-the-content-decoder.patch \
"

SRC_URI:remove = "file://0001-v4l2-Define-ioctl_req_t-for-posix-linux-case.patch"

PACKAGECONFIG_SOUP = "soup2"
RDEPENDS:${PN}-soup += "libsoup-2.4"

PACKAGECONFIG:append = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'novp9', '', 'vpx',d)} \
    wavpack gudev amrnb amrwb \
"

PACKAGECONFIG[amrnb] = "-Damrnb=enabled,-Damrnb=disabled,opencore-amr"
PACKAGECONFIG[amrwb] = "-Damrwbdec=enabled,-Damrwbdec=disabled,opencore-amr"

PV = "1.24.3"

SRC_URI[md5sum] = "3f036e12a857fcac7c244628913460fb"
SRC_URI[sha256sum] = "150f914e61dc05600b68b88ca103c7cc227130158e389ea9ea159f4050a2ebb0"
