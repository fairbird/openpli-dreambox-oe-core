SUMMARY  = "Scrapy is a fast high-level web crawling and web scraping framework"
HOMEPAGE = "https://scrapy.org"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=786239b0f3b0d9c9403f6eecf35820dd"

RDEPENDS:${PN} = "python3-twisted \
    python3-cryptography \
    python3-cssselect \
    python3-pyopenssl \
    python3-zopeinterface \
    python3-service-identity \
    python3-itemloaders \
    python3-parsel \
    python3-queuelib \
    python3-w3lib \
    python3-protego \
    python3-itemadapter \
    python3-h2 \
"

PYPI_PACKAGE = "Scrapy"

SRC_URI[md5sum] = "acbbaf2f42cdd8cb503048e94e25e040"
SRC_URI[sha256sum] = "3cbdedce0c3f0e0482d61be2d7458683be7cd7cf14b0ee6adfbaddb80f5b36a5"

inherit pypi setuptools3_legacy

include python3-package-split.inc
