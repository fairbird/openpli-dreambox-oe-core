MODULE = "Bitrate"
DESCRIPTION = "Bitrate viewer"

require openplugins.inc
inherit autotools gettext python3native

DEPENDS += "python3"

EXTRA_OECONF = " \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR}"

FILES:${PN} = "${libdir} ${bindir}"
