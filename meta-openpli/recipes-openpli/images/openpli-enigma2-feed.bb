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
	network-usb-drivers-meta \
	enigma2-plugin-drivers-network-usb-mt7610u \
	enigma2-plugin-drivers-network-usb-r8712u \
	enigma2-plugin-drivers-network-usb-rt5572 \
	enigma2-plugin-drivers-network-usb-rt73 \
	enigma2-plugin-drivers-network-usb-rtl8188fu \
	enigma2-plugin-drivers-network-usb-rtl8192eu \
	enigma2-plugin-drivers-network-usb-rtl8192fu \
	enigma2-plugin-drivers-network-usb-rtl8814au \
	enigma2-plugin-drivers-network-usb-rtl8821cu \
	enigma2-plugin-drivers-network-usb-rtl8822bu \
	${OPTIONAL_BSP_PACKAGES} \
	${@bb.utils.contains("MACHINE_FEATURES", "dm900 dm920", "qtwidevine" , "", d)} \
	"

OPTIONAL_BSP_ENIGMA2_PACKAGES ?= ""
ENIGMA2_OPTIONAL = " \
	channelsettings-enigma2-meta \
	dvb-usb-drivers-meta \
	${@bb.utils.contains("MACHINE_FEATURES", "bwlcd96 bwlcd128 bwlcd140 bwlcd255 colorlcd220 colorlcd390 colorlcd400", "enigma2-display-skins", "", d)} \
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
	enigma2-plugin-extensions-infobarweather \
	enigma2-plugin-extensions-managerautofs \
	enigma2-plugin-extensions-modifyplifullhd \
	enigma2-plugin-extensions-moviemanager \
	enigma2-plugin-extensions-openmultiboot \
	enigma2-plugin-extensions-refreshbouquet \
	enigma2-plugin-extensions-weathermsn \
	enigma2-plugin-systemplugins-netspeedtest \
	enigma2-plugin-extensions-xmodem \
	enigma2-plugin-extensions-xstreamity \
	enigma2-plugin-extensions-automatic-fullbackup \
	enigma2-plugin-extensions-customsubservices \
	enigma2-plugin-extensions-historyzapselector \
	enigma2-plugin-extensions-sundtekcontrolcenter \
	enigma2-plugin-extensions-ts-sateditor \
	enigma2-plugin-extensions-vcs \
	enigma2-plugin-systemplugins-extnumberzap \
	enigma2-plugin-systemplugins-extrafancontrol \
	enigma2-plugin-systemplugins-mountmanager \
	enigma2-plugin-systemplugins-signalfinder \
	enigma2-plugins \
	enigma2-alliance-plugins \
	meta-enigma2-dvdburn \
	picons-enigma2-meta \
	softcams-enigma2-meta \
	${OPTIONAL_BSP_ENIGMA2_PACKAGES} \
	"

DEPENDS += "${OPTIONAL_PACKAGES} ${ENIGMA2_OPTIONAL}"
