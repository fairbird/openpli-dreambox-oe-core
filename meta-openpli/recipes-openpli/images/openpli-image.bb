require conf/license/openpli-gplv2.inc

inherit image

IMAGE_INSTALL = "\
	${ROOTFS_PKGMANAGE} \
	avahi-daemon \
	ca-certificates \
	cifs-utils \
	cronie \
	dhrystone \
	distro-feed-configs \
	dropbear \
	e2fsprogs-e2fsck \
	e2fsprogs-mke2fs \
	e2fsprogs-tune2fs \
	fuse-exfat \
	glibc-binary-localedata-en-gb \
	hdparm \
	kernel-params \
	modutils-loadscript \
	nfs-utils \
	nfs-utils-client \
	openpli-bootlogo \
	openssh-sftp-server \
	opkg \
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
	tuxbox-common \
	util-linux-ionice \
	tzdata \
	volatile-media \
	vsftpd \
	xz \
"

export IMAGE_BASENAME = "openpli"
IMAGE_LINGUAS = ""
IMAGE_FEATURES += "package-management"

Addntpdatecron() {
	echo "30 * * * *    /usr/bin/ntpdate-sync silent" >> ${IMAGE_ROOTFS}/etc/cron/crontabs/root
}

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

ROOTFS_POSTPROCESS_COMMAND += "Addntpdatecron; removeopkgleftovers; "
