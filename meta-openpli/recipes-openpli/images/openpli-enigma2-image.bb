require openpli-image.bb

ENIGMA2_PLUGINS = " \
	enigma2-plugin-extensions-audiosync \
	enigma2-plugin-extensions-autobackup \
	enigma2-plugin-extensions-bitrate \
	enigma2-plugin-extensions-cdinfo \
	enigma2-plugin-extensions-cutlisteditor \
	enigma2-plugin-extensions-dvdplayer \
	enigma2-plugin-extensions-epgimport \
	enigma2-plugin-extensions-filecommander \
	enigma2-plugin-extensions-graphmultiepg \
	enigma2-plugin-extensions-mediaplayer \
	enigma2-plugin-extensions-mediascanner \
	enigma2-plugin-extensions-moviecut \
	enigma2-plugin-extensions-netcaster \
	enigma2-plugin-extensions-openwebif \
	enigma2-plugin-extensions-pictureplayer \
	enigma2-plugin-extensions-internetspeedtest \
	enigma2-plugin-extensions-systemtools \
	enigma2-plugin-extensions-tmbd \
	enigma2-plugin-extensions-youtube \
	\
	enigma2-plugin-softcams-ncam \
	\
	enigma2-plugin-systemplugins-cablescan \
	enigma2-plugin-systemplugins-commoninterfaceassignment \
	enigma2-plugin-systemplugins-fastscan \
	enigma2-plugin-systemplugins-hdmicec \
	enigma2-plugin-systemplugins-hotplug \
	enigma2-plugin-systemplugins-networkbrowser \
	enigma2-plugin-systemplugins-osd3dsetup \
	enigma2-plugin-systemplugins-osdpositionsetup \
	enigma2-plugin-systemplugins-positionersetup \
	enigma2-plugin-systemplugins-satfinder \
	enigma2-plugin-systemplugins-softwaremanager \
	enigma2-plugin-systemplugins-videoenhancement \
	enigma2-plugin-systemplugins-videomode \
	enigma2-plugin-systemplugins-videotune \
	enigma2-plugin-systemplugins-wirelesslan \
	"

DEPENDS += " \
	enigma2 \
	package-index \
	"

IMAGE_INSTALL += " \
	aio-grab \
	cdtextinfo \
	dhrystone \
	enigma2 \
	libavahi-client \
	settings-autorestore \
	tuxbox-common \
	wget \
	gettext \
	${ENIGMA2_PLUGINS} \
	${@bb.utils.contains("MACHINE_FEATURES", "nowifi", "", "network-usb-drivers-meta", d)} \
	"

export IMAGE_BASENAME = "openpli-enigma2"
