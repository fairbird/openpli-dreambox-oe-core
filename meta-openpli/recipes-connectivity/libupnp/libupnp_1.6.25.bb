DESCRIPTION = "The portable SDK for UPnP* Devices (libupnp) provides developers with an API and open source code for building control points, devices, and bridges that are compliant with Version 1.0 of the Universal Plug and Play Device Architecture Specification."
HOMEPAGE = "http://pupnp.sourceforge.net/"
LICENSE = "BSD"

LIC_FILES_CHKSUM = "file://upnp/LICENSE;md5=b3190d5244e08e78e4c8ee78544f4863"

PR = "r1"

LEAD_SONAME = "libupnp"
SRC_URI = "${SOURCEFORGE_MIRROR}/pupnp/${P}.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "4d2c1e1efe0a19edeef233e14a93f04c"
SRC_URI[sha256sum] = "c5a300b86775435c076d58a79cc0d5a977d76027d2a7d721590729b7f369fa43"
