DESCRIPTION = "OE-A Branding Lib for OE-A 2.0"
MAINTAINER = "oe-alliance team"
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "python3 python3-six-native"

require conf/license/license-gplv2.inc

inherit autotools-brokensep gitpkgv python3targetconfig python3native

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r0"

MACHINEBUILD = "${MACHINE}"

do_configure[nostamp] = "1"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

BRANCH="master"

SRC_URI="git://github.com/oe-mirrors/branding-module.git;protocol=https;branch=${BRANCH} \
        file://ax-python-devel-dont-check-for-distutils.patch \
"

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
    --with-arch="${TUNE_PKGARCH}" \
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

require classes/python3-compileall.inc

FILES:${PN}-src = "${libdir}/enigma2/python/Components/*.py ${libdir}/enigma2/python/Components/*.pyc"
FILES:${PN} = "${libdir}/enigma2/python/*.so /usr/share ${libdir}/enigma2/python/Plugins"
FILES:${PN}-dev += "${libdir}/enigma2/python/*.la"
FILES:${PN}-staticdev += "${libdir}/enigma2/python/*.a"
FILES:${PN}-dbg += "${libdir}/enigma2/python/.debug"
