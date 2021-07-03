# Provide package coreutils-realpath
PACKAGES =+ "${PN}-realpath"

FILES_${PN}-realpath = "${bindir}/realpath.${PN}"

RRECOMMENDS_${PN}_append_class-target = "${PN}-realpath"

ALTERNATIVE_${PN}-realpath = "realpath"
