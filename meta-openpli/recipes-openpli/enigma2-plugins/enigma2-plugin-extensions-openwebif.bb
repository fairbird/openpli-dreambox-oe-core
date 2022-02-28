DESCRIPTION = "Control your receiver with a browser"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;md5=26abba37d1c2fcbf96a087ceb8e1db86"
require classes/python3-compileall.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "python3-cheetah-native"

RDEPENDS:${PN} = "\
	aio-grab \
	python3-cheetah \
	python3-compression\
	python3-ipaddress\
	python3-json \
	python3-misc \
	python3-numbers \
	python3-pyopenssl \
	python3-shell \
	python3-six \
	python3-unixadmin \
	"

inherit gittag distutils-openplugins gettext

PV = "git${SRCPV}"
PKGV = "${GITPKGVTAG}"

SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-OpenWebif.git;protocol=https;branch=master"

SRC_URI_append_dm8000 = " file://get-rid-of-orgdream-check.patch"

S="${WORKDIR}/git"

do_compile() {
	rm -rf ${S}/plugin/public/static/remotes >/dev/null 2>&1 || true
    	ln -sf /usr/share/enigma2/rc_models ${S}/plugin/public/static/remotes
	cheetah-compile -R --nobackup ${S}/plugin
}

PLUGINPATH = "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif"
do_install:append() {
	install -d ${D}${PLUGINPATH}
	cp -r ${S}/plugin/* ${D}${PLUGINPATH}
	chmod a+rX ${D}${PLUGINPATH}
	rm -rf ${D}${libdir}/enigma2/python/Plugins/*.egg-info
	rmdir -p --ignore-fail-on-non-empty ${D}${datadir} ${D}/${PYTHON_SITEPACKAGES_DIR} || true
}

FILES:${PN} = "${PLUGINPATH}"

python do_cleanup () {
    # contains: MACHINE, box image, remote image, remote map
    boxtypes = [
        ('dm500hd', 'dm500hd.png', 'dm_normal.png', 'dmm.html'),
        ('dm7020hd', 'dm7020hd.png', 'dmm2.png', 'dmm2.html'),
        ('dm8000', 'dm8000.png', 'dmm1.png', 'dmm1.html'),
        ('dm800se', 'dm800se.png', 'dm_normal.png', 'dmm.html'),
        ('dm820', 'dm820.png', 'dmm2.png', 'dmm2.html'),
        ('dm7080', 'dm7080.png', 'dmm2.png', 'dmm2.html'),
        ('dm900', 'dm900.png', 'dmm2.png', 'dmm2.html'),
        ('dm920', 'dm920.png', 'dmm2.png', 'dmm2.html'),
        ('dreamone', 'dreamone.png', 'dmm2.png', 'dmm2.html'),
        ('dreamtwo', 'dreamtwo.png', 'dmm2.png', 'dmm2.html'),
    ]

    import os

    pluginpath = "%s%s" % (d.getVar('D', True), d.getVar('PLUGINPATH', True))
    images = "%s/public/images/" % pluginpath
    keymaps = "%s/public/static/" % pluginpath

    target_box = 'unknown.png'
    target_remote = 'ow_remote.png'
    target_keymap = ''
    exception = []

    for x in boxtypes:
        if x[0] == d.getVar('MACHINE', True):
            target_box = x[1]
            target_remote = x[2]
            target_keymap = x[3]

    for root, dirs, files in os.walk(images + 'boxes', topdown=False):
        for name in files:
            if target_box != name and name != 'unknown.png' and exception != name:
                os.remove(os.path.join(root, name))

    for root, dirs, files in os.walk(images + 'remotes', topdown=False):
        for name in files:
            if target_remote != name and name != 'ow_remote.png' and exception != name:
                os.remove(os.path.join(root, name))

    for root, dirs, files in os.walk(keymaps + 'remotes', topdown=False):
        for name in files:
            if target_keymap != name:
                os.remove(os.path.join(root, name))
}

addtask do_cleanup after do_populate_sysroot before do_package

RPROVIDES:${PN} =+ "${PN}-terminal"
DESCRIPTION:${PN}-terminal = "CLI for OpenWebif"
RDEPENDS:${PN}-terminal = "${PN} shellinabox"
RREPLACES:${PN}-terminal = "enigma2-plugin-extensions-openwebif-terminal"
RCONFLICTS:${PN}-terminal = "enigma2-plugin-extensions-openwebif-terminal"
RPROVIDES:${PN}-terminal =+ "enigma2-plugin-extensions-openwebif-terminal"
