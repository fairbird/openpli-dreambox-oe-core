DESCRIPTION = "Open Vision branding lib"
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "python"

require conf/license/openvision-gplv2.inc

inherit autotools-brokensep gitpkgv pythonnative

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

PR[vardepsexclude] += "DATE"

do_configure[nostamp] = "1"

SRC_URI="git://github.com/OpenVisionE2/branding-module.git;protocol=git"

S = "${WORKDIR}/git"

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --with-visionversion="${VISIONVERSION}" \
    --with-visionrevision="${VISIONREVISION}" \
    --with-developername="${DEVELOPER_NAME}" \
    --with-boxbrand="${BOX_BRAND}" \
    --with-oever="${VISIONVERSION}" \
    --with-distro="${DISTRO_NAME}" \
    --with-boxtype="${MACHINE}" \
    --with-brandoem="${BOX_BRAND}" \
    --with-machinebrand="${BOX_BRAND}" \
    --with-machinename="${MACHINE}" \
    --with-machinebuild="${STB_PLATFORM}" \
    --with-machinemake="${MACHINE}" \
    --with-imageversion="${DISTRO_VERSION}" \
    --with-imagebuild="${BUILD_VERSION}" \
    --with-imagedevbuild="${DEVELOPER_BUILD_VERSION}" \
    --with-imagetype="${DISTRO_TYPE}" \
    --with-feedsurl="${DISTRO_FEED_URI}" \
    --with-imagedir="${IMAGEDIR}" \
    --with-imagefs="${IMAGE_FSTYPES}" \
    --with-mtdbootfs="${MTD_BOOTFS}" \
    --with-mtdrootfs="${MTD_ROOTFS}" \
    --with-mtdkernel="${MTD_KERNEL}" \
    --with-rootfile="${ROOTFS_FILE}" \
    --with-kernelfile="${KERNEL_FILE}" \
    --with-mkubifs="${MKUBIFS_ARGS}" \
    --with-ubinize="${UBINIZE_ARGS}" \
    --with-arch="${DEFAULTTUNE}" \
    --with-tfpu="${TARGET_FPU}" \
    --with-display-type="${DISPLAY_TYPE}" \
    --with-small-flash="${HAVE_SMALLFLASH}" \
    --with-middle-flash="${HAVE_MIDDLEFLASH}" \
    --with-transcoding="${HAVE_TRANSCODING}" \
    --with-multitranscoding="${HAVE_MULTITRANSCODING}" \
    --with-multilib="${HAVE_MULTILIB}" \
    --with-hdmi="${HAVE_HDMI}" \
    --with-yuv="${HAVE_YUV}" \
    --with-rca="${HAVE_RCA}" \
    --with-av-jack="${HAVE_AV_JACK}" \
    --with-scart="${HAVE_SCART}" \
    --with-dvi="${HAVE_DVI}" \
    --with-svideo="${HAVE_SVIDEO}" \
    --with-hdmi-in-hd="${HAVE_HDMI_IN_HD}" \
    --with-hdmi-in-fhd="${HAVE_HDMI_IN_FHD}" \
    --with-wol="${HAVE_WOL}" \
    --with-ci="${HAVE_CI}" \
    --with-blindscanbinary="${BLINDSCAN_BINARY}" \
    --with-socfamily="${SOC_FAMILY}" \
    --with-vfd-symbol="${HAVE_VFDSYMBOL}" \
    "

FILES_${PN} = "${libdir}/enigma2/python/*.so"
FILES_${PN}-dev += "${libdir}/enigma2/python/*.la"
FILES_${PN}-staticdev += "${libdir}/enigma2/python/*.a"
FILES_${PN}-dbg += "${libdir}/enigma2/python/.debug"
