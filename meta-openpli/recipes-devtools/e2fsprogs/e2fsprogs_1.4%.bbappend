FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = "file://Revert-mke2fs-enable-the-metadata_csum.patch"
