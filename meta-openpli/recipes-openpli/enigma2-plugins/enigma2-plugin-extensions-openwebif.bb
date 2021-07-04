DESCRIPTION = "Control your receiver with a browser"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;firstline=10;lastline=12;md5=9c14f792d0aeb54e15490a28c89087f7"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "python-cheetah-native"

RDEPENDS_${PN} = "\
	aio-grab \
	python-cheetah \
	python-compression\
	python-ipaddress\
	python-json \
	python-misc \
	python-numbers \
	python-pyopenssl \
	python-shell \
	python-six \
	python-unixadmin \
	"

inherit gitpkgv distutils-openplugins gettext

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-OpenWebif.git"

S="${WORKDIR}/git"

do_compile() {
	cheetah-compile -R --nobackup ${S}/plugin
}

PLUGINPATH = "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif"
do_install_append() {
	install -d ${D}${PLUGINPATH}
	cp -r ${S}/plugin/* ${D}${PLUGINPATH}
	chmod a+rX ${D}${PLUGINPATH}
	rm -rf ${D}${libdir}/enigma2/python/Plugins/*.egg-info
	rmdir -p --ignore-fail-on-non-empty ${D}${datadir} ${D}/${PYTHON_SITEPACKAGES_DIR} || true
}

FILES_${PN} = "${PLUGINPATH}"

python do_cleanup () {
    # contains: MACHINE, box image, remote image, remote map
    boxtypes = [
        ('dm500hd', 'dm500hd.png', 'dm_normal.png', 'dmm.html'),
        ('dm7020hd', 'dm7020hd.png', 'dmm2.png', 'dmm2.html'),
        ('dm8000', 'dm8000.png', 'dmm1.png', 'dmm1.html'),
        ('dm800se', 'dm800se.png', 'dm_normal.png', 'dmm.html'),
        ('dm900', 'dm900.png', 'dmm2.png', 'dmm2.html'),
        ('dm920', 'dm920.png', 'dmm2.png', 'dmm2.html'),
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

RPROVIDES_${PN} =+ "${PN}-terminal"
DESCRIPTION_${PN}-terminal = "CLI for OpenWebif"
RDEPENDS_${PN}-terminal = "${PN} shellinabox"
RREPLACES_${PN}-terminal = "enigma2-plugin-extensions-openwebif-terminal"
RCONFLICTS_${PN}-terminal = "enigma2-plugin-extensions-openwebif-terminal"
RPROVIDES_${PN}-terminal =+ "enigma2-plugin-extensions-openwebif-terminal"
