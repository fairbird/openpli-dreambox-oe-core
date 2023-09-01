SUMMARY = "C++ parsing library for Service Information (SI) in DVB systems"
AUTHOR = "Andreas Oberritter"
SECTION = "libs/multimedia"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI = "git://github.com/oe-alliance/libdvbsi.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
