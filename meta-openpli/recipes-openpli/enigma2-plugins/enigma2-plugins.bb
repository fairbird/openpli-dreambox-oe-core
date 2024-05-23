DESCRIPTION = "Additional plugins for Enigma2"
MAINTAINER = "OpenPLi team <info@openpli.org>"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=8e37f34d0e40d32ea2bc90ee812c9131"

PACKAGES_DYNAMIC = "enigma2-plugin-(?!pli-).*"

# This prevents QA warnings because bitbake cannot see the dependencies
# after parsing the recipe due to the PACKAGES_DYNAMIC stuff. It tells
# the system what to build when installing these into an image.
PACKAGES += "\
	enigma2-plugin-extensions-mosaic \
	enigma2-plugin-extensions-fancontrol2 \
	enigma2-plugin-extensions-bonjour \
	enigma2-plugin-extensions-transmission \
	enigma2-plugin-systemplugins-systemtime \
	"
RDEPENDS:enigma2-plugin-extensions-mosaic = "aio-grab"
RDEPENDS:enigma2-plugin-extensions-fancontrol2 = "smartmontools hdparm"
RDEPENDS:enigma2-plugin-extensions-bonjour = "avahi-daemon"

RRECOMMENDS:enigma2-plugin-systemplugins-blindscan = "virtual/blindscan-dvbs"
RRECOMMENDS:enigma2-plugin-extensions-transmission = "transmission transmission-client"

inherit gitpkgv python3native pkgconfig autotools-brokensep python3targetconfig

PV = "y-git"
PKGV = "y-git${GITPKGV}"

GITHUB_URI ?= "git://github.com"
SRC_URI = "${GITHUB_URI}/OpenPLi/${BPN}.git;branch=python3;protocol=https \
		file://remove-other-type-from-blindscan.patch \
"

EXTRA_OECONF = " \
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	--without-debug \
"

# Main package should be empty
FILES:${PN} = ""
# But something makes the packages think they depend on it, so just
# deliver an empty hulk for them.
ALLOW_EMPTY:${PN} = "1"

FILES:enigma2-plugin-extensions-movietagger += "${sysconfdir}/enigma2/movietags"
CONFFILES:enigma2-plugin-extensions-movietagger += "${sysconfdir}/enigma2/movietags"

FILES:enigma2-plugin-extensions-babelzapper += "${sysconfdir}/babelzapper"
FILES_enigma2-plugin-extensions-lcd4linux += "${libdir}/enigma2/python/Components/Renderer/*.pyc"
FILES_enigma2-plugin-extensions-lcd4linux-src += "${libdir}/enigma2/python/Components/Renderer/*.py"

FILES:enigma2-plugin-extensions-netcaster += "${sysconfdir}/NETcaster.conf"
CONFFILES:enigma2-plugin-extensions-netcaster += "${sysconfdir}/NETcaster.conf"

FILES:${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta ${PN}-build-dependencies"

inherit autotools-brokensep

S = "${WORKDIR}/git"

WARN_QA:remove = "build-deps"

DEPENDS = " \
	python3-pillow \
	python3-pyopenssl \
	python3-pyusb \
	python3-simplejson \
	python3-treq \
	python3-dateutil \
	python3-mutagen \
	python3-twisted \
	python3-daap \
	streamripper \
	libcddb \
	dvdbackup \
	libtirpc \
	png-util \
	pydpflib \
	"

do_compile() {
	python3 -m compileall ${S}
}

CFLAGS += "-I${STAGING_INCDIR}/tirpc"

python populate_packages:prepend () {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\/.*\.po$', 'enigma2-plugin-%s-po', '%s (translations)', recursive=True, match_path=True, prepend=True)

    def getControlLines(mydir, package):
        import os
        try:
            src = open(mydir + package + "/CONTROL/control").read()
        except Exception as ex:
            bb.note("Failed to get control lines for package '%s': %s" % (package, ex))
            return
        for line in src.split("\n"):
            full_package = "enigma2-plugin-extensions-" + package
            if line.startswith('Package: '):
                full_package = line[9:]
            elif line.startswith('Depends: '):
                rdepends = []
                for depend in line[9:].split(','):
                    depend = depend.strip()
                    if depend.startswith('enigma2') and not depend.startswith('enigma2-'):
                        pass # Ignore silly depends on enigma2 with all kinds of misspellings
                    else:
                        rdepends.append(depend)
                rdepends = ' '.join(rdepends)
                d.setVar('RDEPENDS:' + full_package, rdepends)
            elif line.startswith('Recommends: '):
                d.setVar('RRECOMMENDS:' + full_package, line[12:])
            elif line.startswith('Description: '):
                d.setVar('DESCRIPTION:' + full_package, line[13:])
            elif line.startswith('Replaces: '):
                d.setVar('RREPLACES:' + full_package, ' '.join(line[10:].split(', ')))
            elif line.startswith('Conflicts: '):
                d.setVar('RCONFLICTS:' + full_package, ' '.join(line[11:].split(', ')))
            elif line.startswith('Maintainer: '):
                d.setVar('MAINTAINER:' + full_package, line[12:])


    mydir = d.getVar('D') + "/../git/"
    for package in d.getVar('PACKAGES').split():
        getControlLines(mydir, package.split('-')[-1])
}

do_install:append() {
	# remove leftover webinterface garbage
	rm -rf ${D}${libdir}/enigma2/python/Plugins/Extensions/WebInterface
}

# Nothing of this recipe should end up in sysroot, so blank it away.
sysroot_stage_all() {
    :
}

INSANE_SKIP:${PN} = "installed-vs-shipped"

CFLAGS += "-Wno-error=implicit-function-declaration"
