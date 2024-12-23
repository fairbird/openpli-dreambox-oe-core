FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

RDEPENDS:${PN}-core += "python3-service-identity"

SRC_URI:append = " \
	file://0001-fix-writing-after-channel-is-closed.patch \
	file://0001-Revert-Remove-twisted.web.client.getPage-and-friends.patch \
"

include python3-package-split.inc

INSANE_SKIP:${PN} = "installed-vs-shipped"
