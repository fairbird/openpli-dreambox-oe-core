inherit image

IMAGE_LINGUAS = ""
IMAGE_FEATURES += "package-management"

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
	enigma2-plugin-systemplugins-blindscan \
	enigma2-plugin-systemplugins-cablescan \
	enigma2-plugin-systemplugins-commoninterfaceassignment \
	enigma2-plugin-systemplugins-fastscan \
	enigma2-plugin-systemplugins-hdmicec \
	enigma2-plugin-systemplugins-hotplug \
	enigma2-plugin-systemplugins-networkwizard \
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
	enigma-info \
	package-index \
	"

IMAGE_INSTALL = " \
	aio-grab \
	avahi-daemon \
	ca-certificates \
	cdtextinfo \
	cifs-utils \
	cronie \
	distro-feed-configs \
	dropbear \
	e2fsprogs-e2fsck \
	e2fsprogs-mke2fs \
	e2fsprogs-tune2fs \
	enigma2 \
	minilocale \
	fuse-exfat \
	gettext \
	hdparm \
	kernel-params \
	libavahi-client \
	modutils-loadscript \
	nfs-utils \
	nfs-utils-client \
	openpli-bootlogo \
	openssh-sftp-server \
	opkg \
	p7zip \
	packagegroup-base \
	packagegroup-core-boot \
	parted \
	pigz \
	python3-compat2 \
	python3-ipaddress  \
	python3-netifaces \
	python3-pysmb \
	python3-requests \
	sdparm \
	stb-hwclock \
	settings-autorestore \
	tar \
	tuxbox-common \
	tzdata \
	util-linux-ionice \
	util-linux-mount \
	volatile-media \
	vsftpd \
	xz \
	wget \
	mtd-utils \
	mtd-utils-ubifs \
	${ENIGMA2_PLUGINS} \
	${ROOTFS_PKGMANAGE} \
	${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "${NORMAL_IMAGE}", d)} \
	${@bb.utils.contains("TARGET_ARCH", "arm", "${GETEXTRA}", "", d)} \
	${@bb.utils.contains("TARGET_ARCH", "aarch64", "${GETEXTRA}", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "nowifi", "", "network-usb-drivers-meta", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "emmc", "dosfstools mtools e2fsprogs-resize2fs partitions-by-name rsync" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "fastboot", "dosfstools mtools android-tools" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "recovery", "recovery" , "", d)} \
	"

GETEXTRA = "edid-decode"

NORMAL_IMAGE = "\
	flip \
	iproute2 \
	ntfs-3g \
	ofgwrite \
	python3-future \
	python3-pexpect \
	python3-pillow \
	rtmpdump \
	shellinabox \
	unrar \
	zip \
	"

export IMAGE_BASENAME = "openpli-enigma2"

# Remove the mysterious var/lib/opkg/lists that appears to be the result
# of the installer that populates the rootfs. I wanted to call this
# rootfs:remove_opkg_leftovers but that fails to parse.
removeopkgleftovers() {
	rm -r ${IMAGE_ROOTFS}/var/lib/opkg/lists
}

# Some features in image.bbclass we do NOT want, so override them
# to be empty. We want to log in as root, but NOT via SSH. So we want
# to live without debug-tweaks...
zap_root_password () {
	true
}

ssh_allow_empty_password () {
	true
}

license_create_manifest() {
}

ROOTFS_POSTPROCESS_COMMAND += "removeopkgleftovers; "
