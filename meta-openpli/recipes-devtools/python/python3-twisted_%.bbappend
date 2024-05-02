FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

RDEPENDS:${PN}-core += "python3-service-identity"

SRC_URI:append = " \
	file://0001-fix-writing-after-channel-is-closed.patch \
	file://0001-Revert-Remove-twisted.web.client.getPage-and-friends.patch \
"

FILES:${PN} = "${PYTHON_SITEPACKAGES_DIR}/twisted-${PV}.dist-info/*"

INSANE_SKIP:${PN} = "installed-vs-shipped"
