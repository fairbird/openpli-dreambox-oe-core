SUMMARY = "3rd Party plugins for Enigma2"
MAINTAINER = "oe-alliance team"

LICENSE = "LicenseRef-Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=8e37f34d0e40d32ea2bc90ee812c9131"

inherit gitpkgv deploy

DEPENDS = "tslib mpfr gmp"

SRCREV = "${AUTOREV}"
PV = "${IMAGE_VERSION}+gitr"
PKGV = "${IMAGE_VERSION}+gitr${GITPKGV}"
PR = "r23"

SRC_URI = "git://github.com/oe-alliance/3rdparty-plugins-python3.git;branch=main;protocol=https"

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
"

ALLOW_EMPTY:${PN} = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

THIRDPARTY_PLUGINS = " \
    enigma2-plugin-extensions-ipchecker_004_all.ipk \
    enigma2-plugin-extensions-screengrabber_2.6_all.ipk \
    enigma2-plugin-extensions-skyrecorder_2.1.3-py3_all.ipk \
    enigma2-plugin-extensions-xcplugin-forever_2.2_all.ipk \
    "

python populate_packages:prepend () {
    pkg  = ""
    pkgs = ""
    plugins = d.getVar('THIRDPARTY_PLUGINS', True)
    if d.getVar('THIRDPARTY_MACHINE_PLUGINS', True) is not None:
        plugins += d.getVar('THIRDPARTY_MACHINE_PLUGINS', True)
    if d.getVar('THIRDPARTY_EXTRA_PLUGINS', True) is not None:
        plugins += d.getVar('THIRDPARTY_EXTRA_PLUGINS', True)

    if plugins is not None:
        for package in plugins.split():
            pkg = package.split('_')[0]
            pkgs += pkg + " "
            d.setVar('ALLOW_EMPTY:' + pkg, '1')

    d.setVar('PACKAGES', pkgs)
}
