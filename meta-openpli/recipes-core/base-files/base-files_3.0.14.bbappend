# make the package version depend on the name/version of the distro
# this is required for release-to-release upgrades.

do_install_basefilesissue[vardeps] += "DISTRO_NAME DISTRO_VERSION"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://utf8.sh"
SRC_URI += "file://filesystems"

hostname = "${MACHINEBUILD}"

# Detect rootfs filesystem type from IMAGE_FSTYPES (machine configs can override ROOTFS_FSTYPE / ROOTFS_MOUNTOPTS)
def get_rootfs_fstype(d):
    fstypes = (d.getVar('IMAGE_FSTYPES') or '').lower()
    if 'ubi' in fstypes and 'emmc' not in fstypes and 'fastboot' not in fstypes:
        return 'ubifs'
    if 'jffs2' in fstypes:
        return 'jffs2'
    if 'emmc' in fstypes or 'fastboot' in fstypes or 'ext4' in fstypes:
        return 'ext4'
    return 'auto'

def get_rootfs_mountopts(d):
    fstype = get_rootfs_fstype(d)
    provider = d.getVar('PREFERRED_PROVIDER_virtual/kernel') or ''
    kver = (d.getVar('PREFERRED_VERSION_' + provider) or '').replace('%', '0')
    has_lazytime = bb.utils.vercmp_string_op(kver, '4.0', '>=') if kver else False
    if fstype == 'ext4':
        opts = 'defaults,noatime,commit=60'
        if has_lazytime:
            opts += ',lazytime'
        return opts
    if fstype == 'ubifs':
        return 'defaults,noatime,bulk_read'
    return 'defaults,noatime'

ROOTFS_FSTYPE ?= "${@get_rootfs_fstype(d)}"
ROOTFS_MOUNTOPTS ?= "${@get_rootfs_mountopts(d)}"

do_install:append() {
	rm -rf ${D}/mnt
	rm -rf ${D}/hdd
	ln -sf media/hdd ${D}/hdd
	ln -sf media ${D}/mnt
	rm -rf ${D}/media/*
	rm -fr ${D}/tmp

	install -d ${D}${sysconfdir}/profile.d
	install -m 0644 ${UNPACKDIR}/utf8.sh ${D}${sysconfdir}/profile.d/utf8.sh

	install -m 0644 ${UNPACKDIR}/filesystems ${D}${sysconfdir}/filesystems

	install -d ${D}${sysconfdir}/udev

	# Optimize rootfs mount options based on storage type (ROOTFS_FSTYPE/ROOTFS_MOUNTOPTS)
	perl -i -pe 's/auto/${ROOTFS_FSTYPE}/ if /^rootfs/' ${D}${sysconfdir}/fstab
	perl -i -pe 's/defaults/${ROOTFS_MOUNTOPTS}/ if /^rootfs/' ${D}${sysconfdir}/fstab

	if [ "${MACHINEBUILD}" = "dreamone" -o "${MACHINEBUILD}" = "dreamtwo" ]; then
		mkdir ${D}/data
		printf '/dev/dreambox-data\t/data\t\tauto\tdefaults\t\t\t\t0 0\n' >> ${D}${sysconfdir}/fstab
	fi
	if [ "${MACHINEBUILD}" = "dm820" -o "${MACHINEBUILD}" = "dm7080" ]; then
		mkdir ${D}/data
		printf '/dev/mmcblk0p2\t/data\t\tauto\tdefaults\t\t\t\t0 0\n' >> ${D}${sysconfdir}/fstab
	fi
	if [ "${MACHINEBUILD}" = "dm900" -o "${MACHINEBUILD}" = "dm920" ]; then
		mkdir ${D}/data
		printf '/dev/mmcblk0p3\t/data\t\tauto\tdefaults\t\t\t\t0 0\n' >> ${D}${sysconfdir}/fstab
	fi
}
