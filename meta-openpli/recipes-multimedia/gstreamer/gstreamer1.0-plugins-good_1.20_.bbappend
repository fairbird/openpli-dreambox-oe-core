FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG = "${GSTREAMER_ORC} bz2 cairo flac gdk-pixbuf gudev jpeg lame libpng \
                 mpg123 soup speex taglib v4l2 vpx wavpack \
"
