# make the package version depend on the name/version of the distro
# this is required for release-to-release upgrades.

do_install_basefilesissue[vardeps] += "DISTRO_NAME DISTRO_VERSION"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://utf8.sh \
	file://mount-helper.sh \
"

do_install:append() {
	rm -rf ${D}/mnt
	rm -rf ${D}/hdd
	ln -sf media/hdd ${D}/hdd
	ln -sf media ${D}/mnt
	rm -rf ${D}/media/*
	rm -fr ${D}/tmp

	install -d ${D}${sysconfdir}/profile.d
	install -m 0644 ${UNPACKDIR}/utf8.sh ${D}${sysconfdir}/profile.d/utf8.sh

	install -d ${D}${sysconfdir}/udev
	install -m 0755 ${UNPACKDIR}/mount-helper.sh       ${D}${sysconfdir}/udev

	# Inject machine specific blacklists into mount-helper:
	perl -i -pe 's:(\@BLACKLISTED\@):${MTD_BLACK}:s' ${D}${sysconfdir}/udev/mount-helper.sh

	if [ "${MACHINEBUILD}" = "dreamone" -o "${MACHINEBUILD}" = "dreamtwo" ]; then
		mkdir ${D}/data
		printf '/dev/dreambox-data\t/data\t\tauto\tdefaults\t\t\t\t0 0\n' >> ${D}${sysconfdir}/fstab
	fi
}
