MODULE = "OpenWebif"
DESCRIPTION = "Control your receiver with a browser"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://README;md5=eb66cb719ed579d6523cf9c3e000d811"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "python3-cheetah-native"

RDEPENDS:${PN} = "\
	aio-grab \
	python3-cheetah \
	python3-compression \
	python3-ipaddress \
	python3-json \
	python3-misc \
	python3-numbers \
	python3-pprint \
	python3-pyopenssl \
	python3-shell \
	python3-twisted-web \
	python3-unixadmin \
	"

inherit gittag setuptools3_legacy gettext python3-compileall

PV = "git"
PKGV = "${GITPKGVTAG}"

BRANCH="main"

SRC_URI = "git://github.com/oe-alliance/OpenWebif.git;protocol=https;branch=${BRANCH} \
	file://set-packages-explicit.patch \
 	file://get-rid-of-six.patch \
"

S = "${WORKDIR}/git"

do_compile() {
	cheetah-compile -R --nobackup ${S}/plugin
}

PLUGINPATH = "${libdir}/enigma2/python/Plugins/Extensions/${MODULE}"
do_install:append() {
	install -d ${D}${PLUGINPATH}
	cp -r ${S}/plugin/* ${D}${PLUGINPATH}
	chmod a+rX ${D}${PLUGINPATH}
	rm -rf ${D}${libdir}/enigma2/python/Plugins/*.egg-info
	rmdir -p --ignore-fail-on-non-empty ${D}${datadir} ${D}/${PYTHON_SITEPACKAGES_DIR} || true
	python3 -m compileall -o2 -b ${D}${PLUGINPATH}
}

FILES:${PN} = "${PLUGINPATH}"

RPROVIDES:${PN} =+ "${PN}-terminal"
DESCRIPTION:${PN}-terminal = "CLI for OpenWebif"
RDEPENDS:${PN}-terminal = "${PN} shellinabox"
RREPLACES:${PN}-terminal = "enigma2-plugin-extensions-openwebif-terminal"
RCONFLICTS:${PN}-terminal = "enigma2-plugin-extensions-openwebif-terminal"
RPROVIDES:${PN}-terminal =+ "enigma2-plugin-extensions-openwebif-terminal"

INSANE_SKIP:${PN} = "installed-vs-shipped"
