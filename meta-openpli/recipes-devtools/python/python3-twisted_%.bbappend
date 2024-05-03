FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

RDEPENDS:${PN}-core += "python3-service-identity"
RDEPENDS:${PN}-newsfragements = "${PN}-core"

inherit python_setuptools_build_meta

SRC_URI:append = " \
	file://0001-fix-writing-after-channel-is-closed.patch \
	file://0001-Revert-Remove-twisted.web.client.getPage-and-friends.patch \
"

PACKAGES += "${PN}-newsfragments"

FILES:${PN} = "${PYTHON_SITEPACKAGES_DIR}/twisted-${PV}.dist-info/*"

FILES:${PN}-newsfragments = " \
    ${PYTHON_SITEPACKAGES_DIR}/twisted/newsfragments \
"

INSANE_SKIP:${PN} = "installed-vs-shipped"
