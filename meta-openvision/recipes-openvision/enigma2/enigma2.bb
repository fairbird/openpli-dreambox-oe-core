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
	libdreamdvd libdvbsi++ fribidi libmad libpng libsigc++-2.0 giflib libxml2 \
	openssl libudfread \
	python-imaging python-twisted python-wifi \
	swig-native \
	tuxtxt-enigma2 \
	"

# SoftcamSetup is integrated now
RREPLACES_${PN} = "enigma2-plugin-pli-softcamsetup"
RCONFLICTS_${PN} = "enigma2-plugin-pli-softcamsetup"

RDEPENDS_${PN} = " \
	alsa-conf \
	enigma2-data-iso-639-3 \
	enigma2-fonts \
	enigma-module \
	enigma2-remotes \
	enigma2-timezones \
	ethtool \
	glibc-gconv-iso8859-15 \
	ntpdate \
	${PYTHON_RDEPS} \
	"

RRECOMMENDS_${PN} = " \
	enigma2-plugin-skins-pli-hd \
	hotplug-e2-helper \
	glibc-gconv-utf-16 \
	python-sendfile \
	virtual/enigma2-mediaservice \
	"

PYTHON_RDEPS = " \
	python-codecs \
	python-core \
	python-crypt \
	python-fcntl \
	python-lang \
	python-mmap \
	python-logging \
	python-netclient \
	python-netserver \
	python-numbers \
	python-pickle \
	python-process \
	python-pyusb \
	python-re \
	python-service-identity \
	python-shell \
	python-threading \
	python-twisted-core \
	python-twisted-web \
	python-xml \
	python-zlib \
	python-zopeinterface \
	"

# DVD and iso playback is integrated, we need the libraries
RDEPENDS_${PN} += "libdreamdvd libudfread"
RRECOMMENDS_${PN} += "libdvdcss"

# We depend on the font which we use for TXT subtitles (defined in skin_subtitles.xml)
RDEPENDS_${PN} += "font-valis-enigma"

RDEPENDS_${PN} += "virtual/blindscan-dvbc"

DEMUXTOOL ?= "replex"

DESCRIPTION_append_enigma2-plugin-extensions-cutlisteditor = "enables you to cut your movies."
RDEPENDS_enigma2-plugin-extensions-cutlisteditor = "aio-grab"
DESCRIPTION_append_enigma2-plugin-extensions-graphmultiepg = "shows a graphical timeline EPG."
DESCRIPTION_append_enigma2-plugin-extensions-pictureplayer = "displays photos on the TV."
DESCRIPTION_append_enigma2-plugin-systemplugins-positionersetup = "helps you installing a motorized dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-satelliteequipmentcontrol = "allows you to fine-tune DiSEqC-settings."
DESCRIPTION_append_enigma2-plugin-systemplugins-satfinder = "helps you to align your dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-videomode = "selects advanced video modes"
RDEPENDS_enigma2-plugin-systemplugins-nfiflash = "python-twisted-web"
RDEPENDS_enigma2-plugin-systemplugins-softwaremanager = "python-twisted-web"
DESCRIPTION_append_enigma2-plugin-systemplugins-wirelesslan = "helps you configuring your wireless lan"
RDEPENDS_enigma2-plugin-systemplugins-wirelesslan = "wpa-supplicant wireless-tools python-wifi"
DESCRIPTION_append_enigma2-plugin-systemplugins-networkwizard = "provides easy step by step network configuration"
# Note that these tools lack recipes
RDEPENDS_enigma2-plugin-extensions-dvdburn = "dvd+rw-tools dvdauthor mjpegtools cdrkit python-imaging ${DEMUXTOOL}"
RDEPENDS_enigma2-plugin-systemplugins-hotplug = "hotplug-e2-helper"

# Fake package that doesn't actually get built, but allows OE to detect
# the RDEPENDS for the plugins above, preventing [build-deps] warnings.
RDEPENDS_${PN}-build-dependencies = "\
	aio-grab \
	dvd+rw-tools dvdauthor mjpegtools cdrkit python-imaging ${DEMUXTOOL} \
	wpa-supplicant wireless-tools python-wifi \
	python-twisted-web \
	"

inherit gitpkgv pythonnative

PV = "2.7+git${SRCPV}"
PKGV = "2.7+git${GITPKGV}"

ENIGMA2_BRANCH ?= "develop"
GITHUB_URI ?= "git://github.com"

SRC_URI = " ${GITHUB_URI}/OpenPLi/enigma2.git;branch=${ENIGMA2_BRANCH} \
			file://001-adapt-res-to-dm9x0-display.patch \
			file://002-add-skin_display-dm9x0.patch \
			file://003-restore-last-update-date-time.patch;apply=no \
			file://004-Add-Option-Zap-Mode.patch \
			file://005-Restore-AlphaTest-and-craze-changes.patch;apply=no \
			file://006-add-support-2160p.patch \
			file://007-dm9x0-recoverymode.patch;apply=no \
			file://008-dual-tuner-letter-detection.patch \
			file://009-fix-fp-version.patch \
			file://010-fix-framebuffer-and-use-ion-to-allocate-accel-memory.patch \
			file://011-get-rid-of-register-keyword.patch \
			file://012-make-front-led-configurable.patch \
			file://013-move-lcd-text-a-bit-to-the-right.patch \
			file://014-use-ioctl-22-for-h265.patch \
			file://015-fix-build-gcc11.patch \
			file://016-use-mallinfo2.patch \
			"

LDFLAGS_prepend = " -lxml2 "

S = "${WORKDIR}/git"

PACKAGES += "${PN}-meta ${PN}-build-dependencies enigma2-fonts"

inherit autotools pkgconfig

PKGV_enigma2-fonts = "2020.10.17"

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

FILES_enigma2-fonts = "${datadir}/fonts"

FILES_${PN} += "${datadir}/keymaps"

FILES_${PN}-meta = "${datadir}/meta"

# some plugins contain so's, their stripped symbols should not end up in the enigma2 package
FILES_${PN}-dbg += "\
	${libdir}/enigma2/python/Plugins/*/*/.debug \
	"

# Swig generated 200k enigma.py file has no purpose for end users
# Save some space by not installing sources (Startup.py must remain)
FILES_${PN}-src += "\
	${libdir}/enigma2/python/e2reactor.py \
	${libdir}/enigma2/python/enigma.py \
	${libdir}/enigma2/python/GlobalActions.py \
	${libdir}/enigma2/python/keyids.py \
	${libdir}/enigma2/python/keymapparser.py \
	${libdir}/enigma2/python/Navigation.py \
	${libdir}/enigma2/python/NavigationInstance.py \
	${libdir}/enigma2/python/RecordTimer.py \
	${libdir}/enigma2/python/ServiceReference.py \
	${libdir}/enigma2/python/SleepTimer.py \
	${libdir}/enigma2/python/skin.py \
	${libdir}/enigma2/python/timer.py \
	${libdir}/enigma2/python/*/*.py \
	${libdir}/enigma2/python/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*.py \
	"

do_install_append() {
	install -d ${D}${datadir}/keymaps
	find ${D}${libdir}/enigma2/python/ -name '*.pyc' -exec rm {} \;
}

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.py$', 'enigma2-plugin-%s-src', '%s (sources)', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True, extra_depends='')
}
