FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://0001-Revert-Remove-twisted.web.client.getPage-and-friends.patch"
