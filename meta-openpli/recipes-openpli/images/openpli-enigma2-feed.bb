# Creates the "feed", packages not required for the image
# but that should be built for the feed so that other
# components may use them and install on demand.

# We have a GPL-2.0-only license for this recipe...
require conf/license/openpli-gplv2.inc

# Depend on the image, so that it gets build
DEPENDS = "openpli-enigma2-image package-index"

OPTIONAL_PACKAGES_BROKEN = ""
OPTIONAL_PACKAGES ?= ""
OPTIONAL_BSP_PACKAGES ?= ""
OPTIONAL_PACKAGES += " \
	astra-sm \
	autofs \
	autossh \
	ccid \
	cloudflare-dns \
	ctorrent \
	cups \
	davfs2 \
	diffutils \
	dosfstools \
	dvb-apps \
	dvblast \
	dvbsnoop \
	dvdfs \
	edid-decode \
	evtest \
	exfat-utils \
	exteplayer3 \
	gdb \
	google-dns \
	grep \
	gstplayer \
	hddtemp \
	hdparm \
	htop \
	inadyn-mt \
	inetutils \
	iperf3 \
	iproute2 \
	iputils \
	joe \
	less \
	libbluray \
	libudfread \
	mc \
	mediainfo \
	minisatip \
	mpd \
	mt7601u \
	mt7610u \
	mtd-utils \
	mtools \
	nano \
	net-tools \
	ntfs-3g \
	ntp \
	ofgwrite \
	openresolv \
	openssh \
	openvpn \
	parted \
	picocom \
	ppp \
	procps \
	pv \
	pyload \
	python3-beautifulsoup4 \
	python3-js2py \
	python3-lxml \
	python3-mechanize \
	python3-ntplib \
	python3-pysnmp \
	python3-requests \
	python3-youtube-dl \
	rsync \
	rt3573 \
	rt5572 \
	rtl8723a \
	rtl8723bs \
	rtl8814au \
	rtl8822bu \
	rt8812au \
	rtl-sdr \
	rtorrent \
	sabnzbd \
	samba \
	satipclient \
	screen \
	sed \
	smartmontools \
	smbnetfs \
	sshpass \
	strace \
	streamlinksrv \
	tcpdump \
	tmux \
	transmission \
	udpxy \
	usb-modeswitch \
	usb-modeswitch-data \
	v4l-utils \
	vim \
	wget \
	wscan \
	wireless-tools \
	xfsprogs \
	yafc \
	zeroconf \
	zip \
	zsh \
	${OPTIONAL_BSP_PACKAGES} \
	${@bb.utils.contains_any("MACHINE_FEATURES", "dm900 dm920", "kodi" , "", d)} \
	${@bb.utils.contains_any("MACHINE_FEATURES", "dm900 dm920", "qtwidevine" , "", d)} \
	${@bb.utils.contains_any("MACHINE_FEATURES", "dreamone dreamtwo", "${KERNEL_WIFI_DRIVERS}" , "", d)} \
	"

KERNEL_WIFI_DRIVERS = " \
	firmware-carl9170 \
	firmware-htc7010 \
	firmware-htc9271 \
	firmware-rt2870 \
	firmware-rt73 \
	firmware-rtl8712u \
	firmware-zd1211 \
	firmware-rtl8192eu \
	firmware-rtl8188eu \
	\
	rtl8188eu \
	rtl8192eu \
	\
	kernel-module-ath9k-htc \
	kernel-module-carl9170 \
	kernel-module-r8712u \
	kernel-module-rt2500usb \
	kernel-module-rt2800usb \
	kernel-module-rt73usb \
	kernel-module-rtl8187 \
	kernel-module-zd1211rw \
	"

OPTIONAL_BSP_ENIGMA2_PACKAGES ?= ""
ENIGMA2_OPTIONAL = " \
	channelsettings-enigma2-meta \
	dvb-usb-drivers-meta \
	${@bb.utils.contains_any("MACHINE_FEATURES", "bwlcd96 bwlcd128 bwlcd140 bwlcd255 colorlcd220 colorlcd390 colorlcd400", "enigma2-display-skins", "", d)} \
	enigma2-plugin-extensions-arabicsavior \
	enigma2-plugin-extensions-backupflash \
	enigma2-plugin-extensions-keyadder \
	enigma2-plugin-extensions-raedquicksignal \
	enigma2-plugin-drivers-usbserial \
	enigma2-plugin-extensions-backupsuite \
	enigma2-plugin-extensions-autobouquets \
	enigma2-plugin-extensions-e2iplayer \
	enigma2-plugin-extensions-foreca \
	enigma2-plugin-extensions-hetweer \
	enigma2-plugin-extensions-jedimakerxtream \
	enigma2-plugin-extensions-ppanel \
	enigma2-plugin-extensions-oscamstatus \
	enigma2-plugin-extensions-subssupport \
	enigma2-plugin-extensions-xtraevent \
	${@bb.utils.contains_any("MACHINE_FEATURES", "dm900 dm920", "enigma2-plugin-extensions-kodi" , "", d)} \
	enigma2-plugin-security-firewall \
	enigma2-plugin-skins-octetfhd \
	enigma2-plugin-skins-pd1loi-hd-night \
	enigma2-plugin-skins-pli-hd \
	enigma2-plugin-skins-pli-hd-fullnight \
	enigma2-plugin-skins-simple-gray \
	enigma2-plugin-systemplugins-crossepg \
	enigma2-plugin-systemplugins-hrtunerproxy \
	enigma2-plugin-systemplugins-newvirtualkeyboard \
	enigma2-plugin-systemplugins-serviceapp \
	enigma2-plugin-extensions-fontinfo \
	enigma2-plugin-extensions-historyzapselector \
	enigma2-plugin-extensions-infobarweather \
	enigma2-plugin-extensions-managerautofs \
	enigma2-plugin-extensions-modifyplifullhd \
	enigma2-plugin-extensions-moviemanager \
	enigma2-plugin-extensions-openmultiboot \
	enigma2-plugin-extensions-refreshbouquet \
	enigma2-plugin-extensions-weathermsn \
	enigma2-plugin-extensions-vcs \
	enigma2-plugin-extensions-xmodem \
	enigma2-plugin-extensions-xstreamity \
	enigma2-plugin-systemplugins-extnumberzap \
	enigma2-plugin-systemplugins-extrafancontrol \
	enigma2-plugin-systemplugins-mountmanager \
	enigma2-plugin-systemplugins-netspeedtest \
	enigma2-plugin-systemplugins-signalfinder \
	enigma2-plugins \
	meta-enigma2-dvdburn \
	picons-enigma2-meta \
	softcams-enigma2-meta \
	${OPTIONAL_BSP_ENIGMA2_PACKAGES} \
	"

DEPENDS += "${OPTIONAL_PACKAGES} ${ENIGMA2_OPTIONAL}"
