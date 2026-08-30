SUMMARY = "Module for manipulating ID3 (v1 + v2) tags in Python"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "python3 python3-setuptools-scm-native"
RDEPENDS:${PN} = "python3-shell"

SRC_URI[md5sum] = "90d74b6da76fdf31933766e0e0d83cc5"
SRC_URI[sha256sum] = "8f95637ab9f6f305cec6bd1294e197debe207998e3e068596563c74f86b0a173"

inherit pypi setuptools3

include python3-package-split.inc
