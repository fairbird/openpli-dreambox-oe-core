RDEPENDS:${PN}:append = " ${PYTHON_PN}-typing-extensions ${PYTHON_PN}-asyncio"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://0001-Revert-Remove-twisted.web.client.getPage-and-friends.patch"

FILES:${PN}-src = ""
