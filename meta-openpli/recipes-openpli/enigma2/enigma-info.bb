SUMMARY = "enigma.info used by BoxInfo"
PRIORITY = "required"
MAINTAINER = "oe-alliance team"

do_install[depends] += "virtual/kernel:do_package_qa"

require conf/license/openpli-gplv2.inc

deltask fetch
deltask unpack
deltask patch
deltask prepare_recipe_sysroot
deltask configure
deltask compile
deltask source_date_epoch

RCONFLICTS:${PN} = "enigma-kernel-module"
RREPLACES:${PN} = "enigma-kernel-module"

SSTATE_SKIP_CREATION = "1"

PACKAGE_ARCH = "${MACHINEBUILD}"
PV = "${DISTRO_VERSION}"
PR[vardepsexclude] = "DATE"

PACKAGES = "${PN}"

# if DATE in PR changes (next day), workdir name changes too
# this makes sstate unhappy and breakes many tasks in many weird ways

WORKDIR = "${TMPDIR}/work/${MULTIMACH_TARGET_SYS}/${PN}/${EXTENDPE}${PV}"

inherit python3-dir 

INFOFILE = "${libdir}/enigma.info"

inherit linux-kernel-base

do_install[nostamp] = "1"

do_install() {
    YOCTO=`cd "${COREBASE}" && git describe --match=yocto* | cut -d '-' -f 2`
    # Kernel version
    KERNEL_VERSION="${@get_kernelversion_headers('${STAGING_KERNEL_DIR}') or oe.utils.read_file('${PKGDATA_DIR}/kernel-depmod/kernel-abiversion')}"

    DRIVERSDATE='N/A'
    # machine specific
    if [ "${MACHINE}" = "dm7080" ]; then
        DRIVERSDATE="20190502"
    elif [ "${MACHINE}" = "dm820" ]; then
        DRIVERSDATE="20181018"
    elif [ "${MACHINE}" = "dm520" ]; then
        DRIVERSDATE="20180222"
    elif [ "${MACHINE}" = "dm800" ]; then
        DRIVERSDATE="20131228"
    elif [ "${MACHINE}" = "dm8000" ]; then
        DRIVERSDATE="20140604"
    elif [ "${MACHINE}" = "dm7020hd" ] || [ "${MACHINE}" = "dm7020hdv2" ]; then
        DRIVERSDATE="20161019"
    elif [ "${MACHINE}" = "dm800se" ]; then
        DRIVERSDATE="20151201"
    elif [ "${MACHINE}" = "dm800sev2" ]; then
        DRIVERSDATE="20151201"
    elif [ "${MACHINE}" = "dm900" ]; then
        DRIVERSDATE="20200226"
    elif [ "${MACHINE}" = "dm920" ]; then
        DRIVERSDATE="20200321"
    elif [ "${MACHINE}" = "dreamone" ]; then
        DRIVERSDATE="20210518"
    elif [ "${MACHINE}" = "dreamtwo" ]; then
        DRIVERSDATE="20210518"
    fi

    install -d ${D}${libdir}
    printf "architecture='${DEFAULTTUNE}'\n" > ${D}${INFOFILE}
    printf "avjack=${HAVE_AV_JACK}\n" >> ${D}${INFOFILE}
    printf "blindscanbinary='${BLINDSCAN_BINARY}'\n" >> ${D}${INFOFILE}
    printf "brand='${BRAND_OEM}'\n" >> ${D}${INFOFILE}
    printf "ci=${HAVE_CI}\n" >> ${D}${INFOFILE}
    printf "compiledate='${DATE}'\n" >> ${D}${INFOFILE}
    printf "dboxlcd=${SUPPORT_DBOXLCD}\n" >> ${D}${INFOFILE}
    printf "developername='${DEVELOPER_NAME}'\n" >> ${D}${INFOFILE}
    printf "displaybrand='${MACHINE_BRAND}'\n" >> ${D}${INFOFILE}
    printf "displaydistro='${DISPLAY_DISTRO}'\n" >> ${D}${INFOFILE}
    printf "displaymodel='${MACHINE_NAME}'\n" >> ${D}${INFOFILE}
    printf "displaytype='${DISPLAY_TYPE}'\n" >> ${D}${INFOFILE}
    printf "distro='${DISTRO_NAME}'\n" >> ${D}${INFOFILE}
    printf "driversdate='${DRIVERSDATE}'\n" >> ${D}${INFOFILE}
    printf "dvi=${HAVE_DVI}\n" >> ${D}${INFOFILE}
    printf "feedsurl='${DISTRO_FEED_URI}'\n" >> ${D}${INFOFILE}
    printf "fhdskin=${HAVE_FHDSKIN}\n" >> ${D}${INFOFILE}
    printf "fpu='${TARGET_FPU}'\n" >> ${D}${INFOFILE}
    printf "friendlyfamily='${FRIENDLY_FAMILY}'\n" >> ${D}${INFOFILE}
    printf "hdmi=${HAVE_HDMI}\n" >> ${D}${INFOFILE}
    printf "hdmifhdin=${HAVE_HDMI_IN_FHD}\n" >> ${D}${INFOFILE}
    printf "hdmihdin=${HAVE_HDMI_IN_HD}\n" >> ${D}${INFOFILE}
    printf "hdmistandbymode=${HDMISTANDBY_MODE}\n" >> ${D}${INFOFILE}
    printf "imagebuild='${BUILD_VERSION}'\n" >> ${D}${INFOFILE}
    printf "imagedevbuild='${DEVELOPER_BUILD_VERSION}'\n" >> ${D}${INFOFILE}
    printf "imagedir='${IMAGEDIR}'\n" >> ${D}${INFOFILE}
    printf "imagefs='${IMAGE_FSTYPES}'\n" >> ${D}${INFOFILE}
    printf "imagetype='${DISTRO_TYPE}'\n" >> ${D}${INFOFILE}
    printf "imageversion='${DISTRO_VERSION}'\n" >> ${D}${INFOFILE}
    printf "imglanguage='${LANGUAGE}'\n" >> ${D}${INFOFILE}
    printf "imgrevision='${BUILD_VERSION}'\n" >> ${D}${INFOFILE}
    printf "imgversion='${IMAGE_VERSION}'\n" >> ${D}${INFOFILE}
    printf "kernel='${KERNEL_VERSION}'\n" >> ${D}${INFOFILE}
    printf "kexecmb=${HAVE_KEXECMB}\n" >> ${D}${INFOFILE}
    printf "kernelfile='${KERNEL_FILE}'\n" >> ${D}${INFOFILE}
    printf "machinebuild='${MACHINEBUILD}'\n" >> ${D}${INFOFILE}
    printf "mediaservice='${MEDIASERVICE}'\n" >> ${D}${INFOFILE}
    printf "middleflash=${HAVE_MIDDLEFLASH}\n" >> ${D}${INFOFILE}
    printf "mkubifs='${MKUBIFS_ARGS}'\n" >> ${D}${INFOFILE}
    printf "model='${MACHINE}'\n" >> ${D}${INFOFILE}
    printf "mtdbootfs='${MTD_BOOTFS}'\n" >> ${D}${INFOFILE}
    printf "mtdkernel='${MTD_KERNEL}'\n" >> ${D}${INFOFILE}
    printf "mtdrootfs='${MTD_ROOTFS}'\n" >> ${D}${INFOFILE}
    printf "multilib=${HAVE_MULTILIB}\n" >> ${D}${INFOFILE}
    printf "multitranscoding=${HAVE_MULTITRANSCODING}\n" >> ${D}${INFOFILE}
    printf "oe='${OE_VER}'\n" >> ${D}${INFOFILE}
    printf "platform='${STB_PLATFORM}'\n" >> ${D}${INFOFILE}
    printf "python='${PYTHON_BASEVERSION}'\n" >> ${D}${INFOFILE}
    printf "rca=${HAVE_RCA}\n" >> ${D}${INFOFILE}
    printf "rcidnum=${RCIDNUM}\n" >> ${D}${INFOFILE}
    printf "rcname='${RCNAME}'\n" >> ${D}${INFOFILE}
    printf "rctype=${RCTYPE}\n" >> ${D}${INFOFILE}
    printf "rootfile='${ROOTFS_FILE}'\n" >> ${D}${INFOFILE}
    printf "scart=${HAVE_SCART}\n" >> ${D}${INFOFILE}
    printf "noscartswitch=${HAVE_NO_SCART_SWITCH}\n" >> ${D}${INFOFILE}
    printf "scartyuv=${HAVE_SCART_YUV}\n" >> ${D}${INFOFILE}
    printf "smallflash=${HAVE_SMALLFLASH}\n" >> ${D}${INFOFILE}
    printf "socfamily='${SOC_FAMILY}'\n" >> ${D}${INFOFILE}
    printf "svideo=${HAVE_SVIDEO}\n" >> ${D}${INFOFILE}
    printf "timerwakeupmode=${TIMERWAKEUP_MODE}\n" >> ${D}${INFOFILE}
    printf "transcoding=${HAVE_TRANSCODING}\n" >> ${D}${INFOFILE}
    printf "ubinize='${UBINIZE_ARGS}'\n" >> ${D}${INFOFILE}
    printf "vfdsymbol=${HAVE_VFDSYMBOL}\n" >> ${D}${INFOFILE}
    printf "wol=${HAVE_WOL}\n" >> ${D}${INFOFILE}
    printf "wwol=${HAVE_WWOL}\n" >> ${D}${INFOFILE}
    printf "yocto='${YOCTO}'\n" >> ${D}${INFOFILE}
    printf "yuv=${HAVE_YUV}\n" >> ${D}${INFOFILE}
    printf "checksum=%s\n" $(md5sum "${D}${INFOFILE}" | awk '{print $1}') >> ${D}${INFOFILE}
}

do_install[vardepsexclude] += " DATE DATETIME IMAGE_BUILD MACHINEBUILD"

FILES:${PN}:append = " /usr"

do_deploy() {
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 ${D}${INFOFILE} ${DEPLOY_DIR_IMAGE}/enigma-${MACHINEBUILD}.txt
}

addtask deploy before do_package after do_install
