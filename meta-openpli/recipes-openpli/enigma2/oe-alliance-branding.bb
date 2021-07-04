DESCRIPTION = "OE-A Branding Lib for OE-A 2.0"
MAINTAINER = "oe-alliance team"
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "python"

require conf/license/license-gplv2.inc

inherit autotools-brokensep gitpkgv pythonnative

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r0"

MACHINEBUILD = "${MACHINE}"

do_configure[nostamp] = "1"

BRANCH="master"
SRC_URI="git://github.com/oe-alliance/branding-module.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --with-oever="${OE_VER}" \
    --with-distro="${DISTRO_NAME}" \
    --with-boxtype="${MACHINEBUILD}" \
    --with-brandoem="${BRAND_OEM}" \
    --with-machinebrand="${MACHINE_BRAND}" \
    --with-machinename="${MACHINE_NAME}" \
    --with-machinebuild="${MACHINE}" \
    --with-machinemake="${MACHINEBUILD}" \
    --with-imageversion="${DISTRO_VERSION}" \
    --with-imagebuild="${BUILD_VERSION}" \
    --with-imagedevbuild="${DEVELOPER_BUILD_VERSION}" \
    --with-imagetype="${DISTRO_TYPE}" \
    --with-feedsurl="${DISTRO_FEED_URI}" \
    --with-imagedir="${IMAGEDIR}" \
    --with-imagefs="${IMAGE_FSTYPES}" \
    --with-mtdrootfs="${MTD_ROOTFS}" \
    --with-mtdkernel="${MTD_KERNEL}" \
    --with-rootfile="${ROOTFS_FILE}" \
    --with-kernelfile="${KERNEL_FILE}" \
    --with-mkubifs="${MKUBIFS_ARGS}" \
    --with-ubinize="${UBINIZE_ARGS}" \
    --with-driverdate="${DRIVERSDATE}" \
    --with-arch="${DEFAULTTUNE}" \
    --with-display-type="${DISPLAY_TYPE}" \
    --with-hdmi="${HAVE_HDMI}" \
    --with-yuv="${HAVE_YUV}" \
    --with-rca="${HAVE_RCA}" \
    --with-av-jack="${HAVE_AV_JACK}" \
    --with-scart="${HAVE_SCART}" \
    --with-scart-yuv="${HAVE_SCART_YUV}" \
    --with-dvi="${HAVE_DVI}" \
    --with-minitv="${HAVE_MINITV}" \
    --with-hdmi-in-hd="${HAVE_HDMI_IN_HD}" \
    --with-hdmi-in-fhd="${HAVE_HDMI_IN_FHD}" \
    --with-wol="${HAVE_WOL}" \
    --with-wwol="${HAVE_WWOL}" \
    --with-ci="${HAVE_CI}" \
    --with-transcoding="${TRANSCODING}" \
    "

FILES_${PN} = "${libdir}/enigma2/python/*.so"
FILES_${PN}-dev += "${libdir}/enigma2/python/*.la"
FILES_${PN}-staticdev += "${libdir}/enigma2/python/*.a"
FILES_${PN}-dbg += "${libdir}/enigma2/python/.debug"
