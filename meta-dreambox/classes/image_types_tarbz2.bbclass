inherit image_types

IMAGEDIR = "${MACHINE}"
IMAGEVERSION = "openpli-${DISTRO_VERSION}-${MACHINE}-${DATE}"
IMAGEVERSION[vardepsexclude] += "DATE"
BB_HASH_IGNORE_MISMATCH = "1"

IMAGE_CMD:tar = "tar --sort=name --numeric-owner -cf ${IMGDEPLOYDIR}/${IMAGE_NAME}.tar -C ${IMAGE_ROOTFS} . || [ $? -eq 1 ]"

IMAGE_CMD:tar:prepend = " \
    mkdir -p ${IMAGE_ROOTFS}/tmp; \
    "

IMAGE_CMD:tar:append = " \
    rm ${IMAGE_NAME}.rootfs.tar; \
    "

CONVERSION_CMD:bz2 = " \
    rm -f ${DEPLOY_DIR_IMAGE}/*.zip; \
    bzip2 -f -k ${IMAGE_NAME}.tar; \
    mkdir -p ${IMAGEDIR}; \
    cp ${DEPLOY_DIR_IMAGE}/zImage ${IMAGEDIR}/${KERNEL_FILE}; \
    echo "${IMAGEVERSION}" > ${IMAGEDIR}/imageversion; \
    cp ${IMAGE_NAME}.tar.bz2 ${IMAGEDIR}/rootfs.tar.bz2; \
    zip ${IMAGEVERSION}.zip ${IMAGEDIR}/*; \
    rm -f *.manifest; \
    rm -rf ${IMAGEDIR}; \
    "

REPRODUCIBLE_TIMESTAMP_ROOTFS = "${@time.strftime('%s')}"
