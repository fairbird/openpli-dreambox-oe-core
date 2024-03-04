SUMMARY = "The official Python interface to the Flickr API"
HOMEPAGE = "http://stuvel.eu/flickrapi"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
PR = "r1"
# NOTE: requires python3-misc for webbrowser and subprocess as missing dependency of the webbrowser
RDEPENDS:${PN} = "\
  python3-core \
  python3-logging \
  python3-misc \
  python3-netclient \
  python3-subprocess \
  python3-threading \
  python3-xml \
"

SRC_URI = "http://pypi.python.org/packages/source/f/flickrapi/flickrapi-${PV}.zip"
SRC_URI[md5sum] = "90dca08a45968b18da0894887f3e59b3"
SRC_URI[sha256sum] = "ac9304f571175b8af4fc2ee17d3e110847b526640665ca53d97bbf9df98329bc"

S = "${WORKDIR}/flickrapi-${PV}"

inherit setuptools3

include python3-package-split.inc
