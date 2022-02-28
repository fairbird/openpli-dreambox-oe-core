SUMMARY = "GUI frontend for Open Source Linux based receivers"
DESCRIPTION = "Enigma2 is a framebuffer based frontend for DVB functions on Linux settop boxes"
MAINTAINER = "OpenPLi team <info@openpli.org>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = " \
	avahi \
	freetype \
	gettext-native \
	jpeg \
	libdreamdvd libdvbsi++ fribidi libmad libpng libsigc++-3 giflib libxml2 \
	openssl libudfread \
	python3-twisted python3-wifi \
	swig-native \
	tuxtxt-enigma2 \
	"

# SoftcamSetup is integrated now
RREPLACES:${PN} = "enigma2-plugin-pli-softcamsetup"
RCONFLICTS:${PN} = "enigma2-plugin-pli-softcamsetup"

RDEPENDS:${PN} = " \
	alsa-conf \
	oe-alliance-branding \
	enigma2-fonts \
	enigma2-timezones \
	enigma2-remotes \
	enigma2-module \
	ethtool \
	ntpdate \
	glibc-gconv-iso8859-15 \
	${PYTHON_RDEPS} \
	"

RRECOMMENDS:${PN} = " \
	enigma2-plugin-skins-pli-hd \
	hotplug-e2-helper \
	glibc-gconv-utf-16 \
	python-sendfile \
	virtual/enigma2-mediaservice \
	"

PYTHON_RDEPS = " \
	python3-codecs \
	python3-core \
	python3-crypt \
	python3-fcntl \
	python3-logging \
	python3-mmap \
	python3-netclient \
	python3-netserver \
	python3-numbers \
	python3-pickle \
	python3-pyusb \
	python3-service-identity \
	python3-shell \
	python3-threading \
	python3-twisted-core \
	python3-twisted \
	python3-urllib3 \
	python3-xml \
	python3-zopeinterface \
	"

# DVD and iso playback is integrated, we need the libraries
RDEPENDS:${PN} += "libdreamdvd libudfread"
RRECOMMENDS:${PN} += "libdvdcss"

# We depend on the font which we use for TXT subtitles (defined in skin_subtitles.xml)
RDEPENDS:${PN} += "font-valis-enigma"

RDEPENDS:${PN} += "virtual/blindscan-dvbc"

DEMUXTOOL ?= "replex"

DESCRIPTION:append:enigma2-plugin-extensions-cutlisteditor = "enables you to cut your movies."
RDEPENDS:enigma2-plugin-extensions-cutlisteditor = "aio-grab"
DESCRIPTION:append:enigma2-plugin-extensions-graphmultiepg = "shows a graphical timeline EPG."
DESCRIPTION:append:enigma2-plugin-extensions-pictureplayer = "displays photos on the TV."
DESCRIPTION:append:enigma2-plugin-systemplugins-positionersetup = "helps you installing a motorized dish."
DESCRIPTION:append:enigma2-plugin-systemplugins-satelliteequipmentcontrol = "allows you to fine-tune DiSEqC-settings."
DESCRIPTION:append:enigma2-plugin-systemplugins-satfinder = "helps you to align your dish."
DESCRIPTION:append:enigma2-plugin-systemplugins-videomode = "selects advanced video modes"
RDEPENDS:enigma2-plugin-systemplugins-nfiflash = "python3-twisted"
RDEPENDS:enigma2-plugin-systemplugins-softwaremanager = "python3-twisted"
DESCRIPTION:append:enigma2-plugin-systemplugins-wirelesslan = "helps you configuring your wireless lan"
RDEPENDS:enigma2-plugin-systemplugins-wirelesslan = "wpa-supplicant wireless-tools python3-wifi"
DESCRIPTION:append:enigma2-plugin-systemplugins-networkwizard = "provides easy step by step network configuration"
# Note that these tools lack recipes
RDEPENDS:enigma2-plugin-extensions-dvdburn = "dvd+rw-tools dvdauthor mjpegtools cdrkit ${DEMUXTOOL}"
RDEPENDS:enigma2-plugin-systemplugins-hotplug = "hotplug-e2-helper"

# Fake package that doesn't actually get built, but allows OE to detect
# the RDEPENDS for the plugins above, preventing [build-deps] warnings.
RDEPENDS:${PN}-build-dependencies = "\
	aio-grab \
	dvd+rw-tools dvdauthor mjpegtools cdrkit ${DEMUXTOOL} \
	wpa-supplicant wireless-tools python3-wifi \
	python3-twisted-web \
	"

inherit gitpkgv python3native python3targetconfig

PV = "3.10+git${SRCPV}"
PKGV = "3.10+git${GITPKGV}"

ENIGMA2_BRANCH ?= "python3"
GITHUB_URI ?= "git://github.com"

SRC_URI = "${GITHUB_URI}/OpenPLi/enigma2.git;branch=${ENIGMA2_BRANCH};protocol=https \
			file://01-use-ioctl-22-for-h265.patch \
			file://02-add-skin_display-dm920.patch \
			file://03-add-support-2160p.patch \
			file://04-move-lcd-text-a-bit-to-the-right.patch \
			file://05-make-front-led-configurable.patch \
			file://06-fix-build-gcc11.patch \
			file://07-suppress-deprecation-warnings.patch \
			file://08-dual-tuner-letter-detection.patch \
			file://09-update-cutlist-to-beyonwich.patch \
			file://11-Add-remote-control-dmm2.patch \
			file://13-restore-last-update-date-time.patch \
			file://14-fix-framebuffer-and-use-ion-to-allocate-accel-memory.patch \
			file://15-display-openssl-version.patch \
			file://dmm2.png \
"

LDFLAGS:prepend = " -lxml2 "

S = "${WORKDIR}/git"

FILES:${PN} += "${datadir}/keymaps"
FILES:${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta ${PN}-build-dependencies"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools pkgconfig

PACKAGES =+ "enigma2-fonts"
PKGV:enigma2-fonts = "2020.10.17"
FILES:enigma2-fonts = "${datadir}/fonts"

def get_crashaddr(d):
    if d.getVar('CRASHADDR', True):
        return '--with-crashlogemail="${CRASHADDR}"'
    else:
        return ''

EXTRA_OECONF = "\
	--with-libsdl=no --with-boxtype=${MACHINE} \
	--enable-dependency-tracking \
	ac_cv_prog_c_openmp=-fopenmp \
	${@get_crashaddr(d)} \
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

# pass the enigma branch to automake
EXTRA_OEMAKE = "\
	ENIGMA2_BRANCH=${ENIGMA2_BRANCH} \
	"

# Swig generated 200k enigma.py file has no purpose for end users
# some plugins contain so's, their stripped symbols should not end up in the enigma2 package
FILES:${PN}-dbg += "\
	${libdir}/enigma2/python/enigma.py \
	${libdir}/enigma2/python/Plugins/*/*/.debug \
	"

# Save some space by not installing sources (StartEnigma.py must remain)
FILES:${PN}-src = "\
	${libdir}/enigma2/python/e2reactor.py \
	${libdir}/enigma2/python/enigma_py_patcher.py \
    	${libdir}/enigma2/python/GlobalActions.py \
	${libdir}/enigma2/python/keyids.py \
    	${libdir}/enigma2/python/keymapparser.py \
    	${libdir}/enigma2/python/Navigation.py \
    	${libdir}/enigma2/python/NavigationInstance.py \
    	${libdir}/enigma2/python/PowerTimer.py \
    	${libdir}/enigma2/python/RecordTimer.py \
    	${libdir}/enigma2/python/ServiceReference.py \
    	${libdir}/enigma2/python/skin.py \
    	${libdir}/enigma2/python/timer.py \
    	${libdir}/enigma2/python/upgrade.py \
    	${libdir}/enigma2/python/*/*.py \
    	${libdir}/enigma2/python/*/*/*.py \
    	${libdir}/enigma2/python/*/*/*/*.py \
    	"

do_install:append() {
	cp ${WORKDIR}/dmm2.png ${B}/data/rc_models/dmm2.png
	install -d ${D}${datadir}/keymaps
	if [ "${base_libdir}" = "/lib64" ] ; then
        	install -d ${D}/usr/lib
        	ln -s ${libdir}/enigma2 ${D}/usr/lib/enigma2
        	ln -s ${libdir}/${PYTHON_DIR} ${D}/usr/lib/${PYTHON_DIR}
	fi
}

python populate_packages:prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', '%s (source files)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True, extra_depends='')
}
