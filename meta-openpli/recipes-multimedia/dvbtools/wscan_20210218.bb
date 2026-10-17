SUMMARY = "Small command line utility used to perform frequency scans for DVB and ATSC transmissions"
DESCRIPTION = "Wscan is a dvb channel scanner that doesn't require an initial frequency table"
HOMEPAGE = "http://wirbel.htpc-forum.de/w_scan/index2.html"
MAINTAINER = "wirbel <w_scan@gmx-topmail.de>"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI = "https://www.gen2vdr.de/wirbel/w_scan_cpp/w_scan-${PV}.tar.bz2"

SRC_URI[md5sum] = "e87b267ea5c0310aba219f2ceb92404f"
SRC_URI[sha256sum] = "9ca90b0cbac68cdfd7330c7732d296ca5b295ac54b8b1ae92d2a16afe3987b8a"

S = "${UNPACKDIR}/w_scan-${PV}"

inherit autotools

FILES:${PN} += "${datadir}"

CFLAGS += "-std=gnu17"
