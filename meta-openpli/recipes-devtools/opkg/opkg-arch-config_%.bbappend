PACKAGE_ARCH = "${MACHINEBUILD}"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

do_compile:append:mipsel() {
    echo "arch ${TARGET_ARCH} $priority" >> $archconf
}

# add support for extra feeds
PACKAGE_ARCHS += " ocram"

do_compile:append:bcm7252s() {
    echo "arch armv7ahf-vfp-neon $priority" >> $archconf
    echo "arch armv7ahf-neon $priority" >> $archconf
}

do_compile:append:aarch64() {
    echo "arch arm64 $priority" >> $archconf
}
