SUMMARY = "Custom Skins for Enigma2"
MAINTAINER = "openvix"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://README.md;startline=1;endline=6;md5=f9196ec9a7923f62b4ebd01baef09a1d"

PACKAGES = "${PN} ${PN}-meta enigma2-plugin-skincomponents-metrix-src enigma2-plugin-skincomponents-novum-src"
PACKAGES_DYNAMIC = "enigma2-plugin-skins-openvix-*"

inherit gitpkgv autotools-brokensep rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenViX/skins.git;protocol=git"

DEPENDS += "enigma2 enigma2-plugin-fonts-roboto enigma2-plugin-fonts-valis-hd enigma2-plugin-extensions-yahooweather"

# note that enigma2-skins is just an empty package to satisfy silly dependencies.
ALLOW_EMPTY_${PN} = "1"
FILES_${PN} = "${datadir}/enigma2"
FILES_${PN}-meta = "${datadir}/meta"

RDEPENDS_${PN}-meta = ""
RDEPENDS_enigma2-plugin-skins-openvix-metrixhd = "enigma2-plugin-skincomponents-metrix"
RDEPENDS_enigma2-plugin-skins-openvix-metrixfhd = "enigma2-plugin-skincomponents-metrix"
RDEPENDS_enigma2-plugin-skins-openvix-mynovum-fhd2 = "enigma2-plugin-skincomponents-novum"
RDEPENDS_enigma2-plugin-skins-openvix-mynovum-fhd2-black = "enigma2-plugin-skincomponents-novum"
RDEPENDS_enigma2-plugin-skins-openvix-novum-fhd-slim = "enigma2-plugin-skincomponents-novum"
RDEPENDS_enigma2-plugin-skins-openvix-magic-sd = "enigma2-plugin-fonts-valis-hd"
RDEPENDS_enigma2-plugin-skins-openvix-magic-hd-night = "enigma2-plugin-skins-openvix-mhd-common enigma2-plugin-fonts-valis-hd"
RDEPENDS_enigma2-plugin-skins-openvix-magic-hd-noire = "enigma2-plugin-skins-openvix-mhd-common enigma2-plugin-fonts-valis-hd"
RDEPENDS_enigma2-plugin-skins-openvix-vix-day-hd = "enigma2-plugin-skins-openvix-vix-common enigma2-plugin-fonts-roboto"
RDEPENDS_enigma2-plugin-skins-openvix-vix-night-hd = "enigma2-plugin-skins-openvix-vix-common enigma2-plugin-fonts-roboto"
RDEPENDS_enigma2-plugin-skins-openvix-vixbmc-night-hd = "enigma2-plugin-skins-openvix-vixbmc-hd-common"
RDEPENDS_enigma2-plugin-skins-openvix-vixbmc-slim-hd = "enigma2-plugin-skins-openvix-vixbmc-hd-common"
RDEPENDS_enigma2-plugin-skins-openvix-vixbmc-metropolis = "enigma2-plugin-skins-openvix-vixbmc-hd-common"
RDEPENDS_enigma2-plugin-skins-openvix-youvix-blue = "enigma2-plugin-skins-openvix-youvix-common"
RDEPENDS_enigma2-plugin-skins-openvix-youvix-green = "enigma2-plugin-skins-openvix-youvix-common"
RDEPENDS_enigma2-plugin-skins-openvix-youvix-purple = "enigma2-plugin-skins-openvix-youvix-common"
RDEPENDS_enigma2-plugin-skins-openvix-youvix-red = "enigma2-plugin-skins-openvix-youvix-common"
RDEPENDS_enigma2-plugin-skins-openvix-vixbmc-1080-bello = "enigma2-plugin-skins-openvix-vixbmc-1080-common"
RDEPENDS_enigma2-plugin-skins-openvix-vixbmc-1080-confluence = "enigma2-plugin-skins-openvix-vixbmc-1080-common"
RDEPENDS_enigma2-plugin-skins-openvix-iskin-light = "enigma2-plugin-skins-openvix-iskin-common"
RDEPENDS_enigma2-plugin-skins-openvix-iskin-dark = "enigma2-plugin-skins-openvix-iskin-common"

FILES_enigma2-plugin-skincomponents-metrix += "${libdir}/enigma2/python/Components/Converter/RemainingToTextMod.${PYTHONEXTENSION} ${libdir}/enigma2/python/Components/Converter/MetrixCombinedEventName.${PYTHONEXTENSION} ${libdir}/enigma2/python/Components/Converter/ClockToTextMod.${PYTHONEXTENSION} ${libdir}/enigma2/python/Components/Converter/MetrixRefString.${PYTHONEXTENSION} ${libdir}/enigma2/python/Components/Converter/vhdConvEventName.${PYTHONEXTENSION} ${libdir}/enigma2/python/Components/Converter/MetrixWeather.${PYTHONEXTENSION} ${libdir}/enigma2/python/Components/Converter/EventNameMod.${PYTHONEXTENSION} ${libdir}/enigma2/python/Components/Renderer/VReference.py ${libdir}/enigma2/python/Components/Renderer/VReference.${PYTHONEXTENSION} ${libdir}/enigma2/python/Components/Renderer/XPicon.${PYTHONEXTENSION} ${libdir}/enigma2/python/Components/Renderer/XPiconChannel.${PYTHONEXTENSION} ${libdir}/enigma2/python/Components/Renderer/VVolumeText.${PYTHONEXTENSION} ${libdir}/enigma2/python/Components/Renderer/NextEvent.${PYTHONEXTENSION}"
FILES_enigma2-plugin-skincomponents-metrix-src += "${libdir}/enigma2/python/Components/Converter/EventNameMod.py ${libdir}/enigma2/python/Components/Converter/RemainingToTextMod.py ${libdir}/enigma2/python/Components/Converter/vhdConvEventName.py ${libdir}/enigma2/python/Components/Converter/MetrixRefString.py ${libdir}/enigma2/python/Components/Converter/MetrixWeather.py ${libdir}/enigma2/python/Components/Converter/MetrixCombinedEventName.py ${libdir}/enigma2/python/Components/Converter/ClockToTextMod.py ${libdir}/enigma2/python/Components/Renderer/VVolumeText.py ${libdir}/enigma2/python/Components/Renderer/XPicon.py ${libdir}/enigma2/python/Components/Renderer/XPiconChannel.py ${libdir}/enigma2/python/Components/Renderer/NextEvent.py"
FILES_enigma2-plugin-skincomponents-novum += "${libdir}/enigma2/python/Components/Renderer/NovSingleEpgListNobile.${PYTHONEXTENSION}  ${libdir}/enigma2/python/Components/Converter/NovumEventsInfo.${PYTHONEXTENSION}"
FILES_enigma2-plugin-skincomponents-novum-src += "${libdir}/enigma2/python/Components/Renderer/NovSingleEpgListNobile.py  ${libdir}/enigma2/python/Components/Converter/NovumEventsInfo.py"

S = "${WORKDIR}/git"

EXTRA_OECONF += "--with-skins1080"

python populate_packages_prepend() {
    enigma2_skindir = bb.data.expand('${datadir}/enigma2', d)
    do_split_packages(d, enigma2_skindir, '(.*?)/.*', 'enigma2-plugin-skins-openvix-%s', 'Enigma2 Skin Pack: %s', recursive=True, match_path=True, prepend=True, extra_depends="enigma2")
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends="enigma2")
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', '%s (source files)', recursive=True, match_path=True, prepend=True, extra_depends="enigma2")
}

deltask do_populate_sysroot
