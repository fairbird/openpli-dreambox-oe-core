SUMMARY = "Collection of enigma2 subtitles plugins"
HOMEPAGE = "https://github.com/mx3L/subssupport"
AUTHOR = "Maroš Ondrášek <mx3ldev@gmail.com>"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit gitpkgv python3-compileall

PR = "r14"

RDEPENDS:${PN} = " \
	python3-codecs \
	python3-compression \
	python3-difflib \
	python3-json \
	python3-requests \
	python3-xmlrpc \
	python3-beautifulsoup4 \
	unrar \
	"

SRC_URI = "git://github.com/fairbird/subssupport;protocol=git;branch=master;protocol=https"

S = "${WORKDIR}/git"

pluginpath = "${libdir}/enigma2/python/Plugins/Extensions/SubsSupport"

FILES:${PN} = "${pluginpath}/"

do_install() {
    install -d ${D}${pluginpath}
    cp -r ${S}/plugin/* ${D}${pluginpath}/
}
