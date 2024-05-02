FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

LIC_FILES_CHKSUM = "file://LICENSE;md5=c1c5d2c2493b848f83864bdedd67bbf5"

DEPENDS += "python3-hatch-fancy-pypi-readme-native"
RDEPENDS:${PN}-newsfragements = "${PN}-core"

inherit python_hatchling

PV = "24.3.0"
PYPI_PACKAGE = "twisted"

SRC_URI:append = "https://files.pythonhosted.org/packages/fc/8d/9c09d75173984d3b0f0dcf65d885fe61a06de11db2c30b1196d85f631cfc/twisted-${PV}.tar.gz \
		file://0001-fix-writing-after-channel-is-closed.patch \
		file://0001-Revert-Remove-twisted.web.client.getPage-and-friends.patch \
"
SRC_URI:remove = "https://files.pythonhosted.org/packages/source/T/Twisted/Twisted-${PV}.tar.gz;downloadfilename=Twisted-${PV}.tar.gz"

SRC_URI[sha256sum] = "6b38b6ece7296b5e122c9eb17da2eeab3d98a198f50ca9efd00fb03e5b4fd4ae"

PACKAGES += "${PN}-newsfragments"

FILES:${PN}-newsfragments = " \
    ${PYTHON_SITEPACKAGES_DIR}/twisted/newsfragments \
"

FILES:${PN} = "${PYTHON_SITEPACKAGES_DIR}/${PYPI_PACKAGE}-${PV}.dist-info/*"
