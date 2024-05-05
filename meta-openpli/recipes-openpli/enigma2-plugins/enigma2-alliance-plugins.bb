SUMMARY = "Additional plugins for Enigma2"
MAINTAINER = "oe-alliance team"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=8e37f34d0e40d32ea2bc90ee812c9131"

PACKAGE_ARCH = "${MACHINE_ARCH}"

include python3-package-split.inc

inherit python3-dir autotools-brokensep gitpkgv python3native gettext python3targetconfig

SRCREV = "${AUTOREV}"
PV = "git"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/oe-alliance/oe-alliance-plugins.git;protocol=https;branch=master \
	file://remove-unused-plugins.patch \
"

S = "${WORKDIR}/git"

PROVIDES = "\
    enigma2-plugin-extensions-btdevicesmanager \
    enigma2-plugin-extensions-fempa \
    enigma2-plugin-extensions-ondemand \
    enigma2-plugin-extensions-rcuselect \
    enigma2-plugin-extensions-rezap \
    enigma2-plugin-extensions-streamtv \
    enigma2-plugin-extensions-tunerserver \
    enigma2-plugin-extensions-webbrowser \
    enigma2-plugin-systemplugins-abmcustommiximporter \
    enigma2-plugin-systemplugins-audioeffect \
    enigma2-plugin-systemplugins-channelsimporter \
    enigma2-plugin-systemplugins-ewvfdcontrol \
    enigma2-plugin-systemplugins-f3ledcontrol \
    enigma2-plugin-systemplugins-firmwareupgrade \
    enigma2-plugin-systemplugins-fpgaupgrade \
    enigma2-plugin-systemplugins-gigablueremote \
    enigma2-plugin-systemplugins-gigabluevfdcontrol \
    enigma2-plugin-systemplugins-inivfdcontrol \
    enigma2-plugin-systemplugins-micomupgrade \
    enigma2-plugin-systemplugins-multitranscodingsetup \
    enigma2-plugin-systemplugins-odinm7vfdcontrol \
    enigma2-plugin-systemplugins-remotecontrolcode \
    enigma2-plugin-systemplugins-sf8vfdcontrol \
    enigma2-plugin-systemplugins-simplefancontrol \
    enigma2-plugin-systemplugins-ventonfancontrol \
    enigma2-plugin-systemplugins-vpledcontrol \
    enigma2-plugin-systemplugins-vuduofancontrol \
    ${@bb.utils.contains("MACHINE_FEATURES", "legacykernel", "" , "enigma2-plugin-systemplugins-wirelessaccesspoint", d)} \
    enigma2-plugin-systemplugins-xtrendfancontrol \
    enigma2-plugin-systemplugins-xtrendremote \
    "

DEPENDS = "\
    ${@bb.utils.contains('MACHINE_FEATURES', 'transcoding', 'virtual-transtreamproxy' , '', d)} \
    python3-dnspython python3-beautifulsoup4 python3-lxml python3-simplejson python3-pyamf python3-icalendar python3-pyusb python3-six-native \
    rtmpdump \
    minidlna \
    hddtemp \
    ppp \
    usb-modeswitch \
    usb-modeswitch-data \
    usbutils \
    bluez-conf \
    bluez-hidd \
    bluez-alsa \
    ${@bb.utils.contains('MACHINE_FEATURES', 'legacykernel', '' , 'hostapd bridge-utils', d)} \
    wvdial wvstreams \
    "

DESCRIPTION_enigma2-plugin-extensions-btdevicesmanager = "BT devices manger to pair e.x keyboard or mouse"
RDEPENDS_enigma2-plugin-extensions-btdevicesmanager = "bluez5-testtools bluez5 bluez-hcidump bluez-conf bluez-hidd bluez-alsa alsa-utils-aplay python3-pexpect"
#DESCRIPTION_enigma2-plugin-extensions-dlnaserver = "this is dlna server using minidlna"
#RDEPENDS_enigma2-plugin-extensions-dlnaserver = "minidlna"
DESCRIPTION_enigma2-plugin-extensions-fempa = "Norwegian P4 FEM PAA radio show player."
DESCRIPTION_enigma2-plugin-extensions-ondemand = "Watch on demand TV."
RDEPENDS_enigma2-plugin-extensions-ondemand = "python3-beautifulsoup python3-dnspython python3-lxml python3-pyamf python3-simplejson"
DESCRIPTION_enigma2-plugin-extensions-rcuselect = "Change Remote for Amlogic"
DESCRIPTION_enigma2-plugin-extensions-rezap = "ReZap Sync Tool for Wetek"
DESCRIPTION_enigma2-plugin-extensions-streamtv = "iptv player"
RDEPENDS_enigma2-plugin-extensions-streamtv = "rtmpdump"
DESCRIPTION_enigma2-plugin-extensions-tunerserver = "Builds a virtual channels list"
DESCRIPTION_enigma2-plugin-extensions-webbrowser = "Webbrowser launcher"
FILES:enigma2-plugin-extensions-webbrowser:append = "${datadir}/keymaps"
RDEPENDS_enigma2-plugin-extensions-webbrowser = "python3-gdata-python3 libqtwebkite4 webbrowser-utils qt4-embedded-fonts qt4-embedded-plugin-imageformat-gif qt4-embedded-plugin-imageformat-ico qt4-embedded-plugin-imageformat-jpeg qt4-embedded-plugin-imageformat-mng qt4-embedded-plugin-imageformat-svg qt4-embedded-plugin-imageformat-tiff qt4-embedded-plugin-iconengine-svgicon"
DESCRIPTION_enigma2-plugin-systemplugins-abmcustommiximporter = "Imports ABM CustomMix files from Github."
DESCRIPTION_enigma2-plugin-systemplugins-audioeffect = "Audio Effect setup"
DESCRIPTION_enigma2-plugin-systemplugins-channelsimporter = "Imports a copy of the channel list from a remote receiver and loads it on the local receiver."
DESCRIPTION_enigma2-plugin-systemplugins-xtrendfancontrol = "Control your internal system fan."
RDEPENDS_enigma2-plugin-systemplugins-xtrendfancontrol = "hddtemp"
DESCRIPTION_enigma2-plugin-systemplugins-firmwareupgrade = "Upgrade your system Firmware"
DESCRIPTION_enigma2-plugin-systemplugins-fpgaupgrade = "Upgrade your system FPGA"
DESCRIPTION_enigma2-plugin-systemplugins-micomupgrade = "micomupgrade"
DESCRIPTION_enigma2-plugin-systemplugins-multitranscodingsetup = "Setup multitranscoding"
DESCRIPTION_enigma2-plugin-systemplugins-wirelessaccesspoint = "Using a Wireless module as AP."
RDEPENDS_enigma2-plugin-systemplugins-wirelessaccesspoint = "bridge-utils hostapd"

ALLOW_EMPTY:${PN} = "1"
PACKAGES += "${PN}-meta"
FILES:${PN}-meta = "${datadir}/meta"

EXTRA_OECONF = "\
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --with-boxtype=${MACHINE} \
    --with-arch=${TARGET_ARCH} \
    --with-pythonver=python3 \
    "

python populate_packages:prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', '%s (source files)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\/.*\.po$', 'enigma2-plugin-%s-po', '%s (translations)', recursive=True, match_path=True, prepend=True)
}

do_package_qa() {
}
