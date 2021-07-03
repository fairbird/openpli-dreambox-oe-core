# split out gpgv from main package
RDEPENDS_${PN} = "gpgv"
PACKAGES =+ "gpgv"
FILES_gpgv = "${bindir}/gpgv"
