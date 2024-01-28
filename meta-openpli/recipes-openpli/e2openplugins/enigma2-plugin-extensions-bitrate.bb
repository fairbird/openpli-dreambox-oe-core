MODULE = "Bitrate"
DESCRIPTION = "Bitrate viewer"

require conf/license/license-gplv2.inc

require openplugins.inc

inherit autotools gettext python3native

DEPENDS += "python3"

SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-Bitrate.git;branch=python3;protocol=https"

EXTRA_OECONF = " \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR}"

FILES:${PN} = "${libdir} ${bindir}"
