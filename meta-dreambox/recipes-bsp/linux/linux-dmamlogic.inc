DESCRIPTION = "Linux kernel for ${MACHINE}"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel machine_kernel_pr samba_change_dialect siteinfo

CMDLINE ?= ""
LOCALVERSION ?= ""

#kernel_conf_variable CMDLINE "\"${CMDLINE} ${CMDLINE_DEBUG}\""
kernel_conf_variable() {
    CONF_SED_SCRIPT="$CONF_SED_SCRIPT /CONFIG_$1[ =]/d;"
    if test "$2" = "n"
    then
        echo "# CONFIG_$1 is not set" >> ${B}/.config
    else
        echo "CONFIG_$1=$2" >> ${B}/.config
    fi
}

DEFCONFIG_IN_SRC_URI = "${@bb.utils.contains('SRC_URI', 'file://defconfig', 'true', 'false', d)}"

do_configure_prepend() {
    sed -e "/^SUBLEVEL = /d" -i ${S}/Makefile

    if [ -n "${DEFCONFIG}" ] && ! ${DEFCONFIG_IN_SRC_URI}; then
        yes '' | oe_runmake -C ${S} O=${B} ${DEFCONFIG}_defconfig
        mv -f ${B}/.config ${WORKDIR}/defconfig
    fi

    echo "" > ${B}/.config
    CONF_SED_SCRIPT=""

    if [ -n "${CMDLINE}" ]; then
        kernel_conf_variable CMDLINE "\"${CMDLINE}\""
    fi

    if [ -n "${LOCALVERSION}" ]; then
        kernel_conf_variable LOCALVERSION "\"${LOCALVERSION}\""
    fi
    kernel_conf_variable LOCALVERSION_AUTO n

    kernel_conf_variable SYSFS_DEPRECATED n
    kernel_conf_variable SYSFS_DEPRECATED_V2 n
    kernel_conf_variable HOTPLUG y
    kernel_conf_variable SYSFS y
    kernel_conf_variable PROC_FS y
    kernel_conf_variable INOTIFY_USER y
    kernel_conf_variable SIGNALFD y
    kernel_conf_variable BLK_DEV_BSG y

    # Newer inits like systemd need cgroup support
    if [ "${KERNEL_ENABLE_CGROUPS}" = "1" ] ; then
        kernel_conf_variable CGROUP_SCHED y
        kernel_conf_variable CGROUPS y
        kernel_conf_variable CGROUP_NS y
        kernel_conf_variable CGROUP_FREEZER y
        kernel_conf_variable CGROUP_DEVICE y
        kernel_conf_variable CPUSETS y
        kernel_conf_variable PROC_PID_CPUSET y
        kernel_conf_variable CGROUP_CPUACCT y
        kernel_conf_variable RESOURCE_COUNTERS y
    fi

    kernel_conf_variable CDROM_PKTCDVD m
    kernel_conf_variable CDROM_PKTCDVD_BUFFERS=8
    kernel_conf_variable CDROM_PKTCDVD_WCACHE n
    kernel_conf_variable DEFAULT_HOSTNAME="${MACHINE}"
    kernel_conf_variable PRINTK y
    kernel_conf_variable EXT2_FS m
    kernel_conf_variable EXT4_FS y
    kernel_conf_variable MSDOS_PARTITION y
    kernel_conf_variable FAT_FS y
    kernel_conf_variable USB_SERIAL_IUU m
    kernel_conf_variable FSCACHE y
    kernel_conf_variable CHR_DEV_SG y
    kernel_conf_variable NTFS_RW n
    kernel_conf_variable FS_MBCACHE y
    kernel_conf_variable MTD_NAND_NANDSIM m
    kernel_conf_variable MTD_BLOCK2MTD m
    kernel_conf_variable INPUT_JOYDEV m
    kernel_conf_variable USB_SERIAL_SIMPLE m
    kernel_conf_variable INPUT_MOUSEDEV m
    kernel_conf_variable XFS_FS m
    kernel_conf_variable INPUT_MOUSE y
    kernel_conf_variable INPUT_KEYBOARD y
    kernel_conf_variable NLS_DEFAULT="utf8"
    kernel_conf_variable HAVE_DMA_API_DEBUG y
    kernel_conf_variable USB_SERIAL_GENERIC y
    kernel_conf_variable USB_SERIAL_KEYSPAN m
    kernel_conf_variable USB_SERIAL_WWAN m
    kernel_conf_variable USB_SERIAL_OPTION m
    kernel_conf_variable HID_A4TECH m
    kernel_conf_variable HID_BELKIN m
    kernel_conf_variable HID_EZKEY m
    kernel_conf_variable HID_MICROSOFT m
    kernel_conf_variable HID_LOGITECH m
    kernel_conf_variable HID_LOGITECH_DJ m
    kernel_conf_variable USB_HID m

    sed -e "${CONF_SED_SCRIPT}" \
    < '${WORKDIR}/defconfig' >>'${B}/.config'

    yes '' | oe_runmake -C ${S} O=${B} oldconfig
}

do_configure_append() {
    if test -e scripts/Makefile.fwinst ; then
        sed -i -e "s:-m0644:-m 0644:g" scripts/Makefile.fwinst
    fi
    sed -i "s/(none)/${MACHINE}/" "${WORKDIR}/defconfig"
}

do_install_append() {
    oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix}/src/linux-${KERNEL_VERSION} ARCH=$ARCH
}

PACKAGES =+ "${KERNEL_PACKAGE_NAME}-headers"
FILES_${KERNEL_PACKAGE_NAME}-headers = "${exec_prefix}/src/linux*"
