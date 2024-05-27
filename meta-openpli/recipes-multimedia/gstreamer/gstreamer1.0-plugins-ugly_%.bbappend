PACKAGECONFIG:append = " \
    cdio dvdread \
"

PACKAGE_NO_LOCALE = "1"

PACKAGECONFIG[amrnb]    = ""
PACKAGECONFIG[amrwb]    = ""

PV = "1.24.3"

SRC_URI[md5sum] = "31a11c5796077bbdfd938a68520bf385"
SRC_URI[sha256sum] = "4c951341c4c648630b6fe1234ec113d81dd2d248529bf2b5478e0ad077c80ed3"
