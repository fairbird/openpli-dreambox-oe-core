IMAGE_FSTYPES =+ "tar.bz2"

CONVERSION_CMD:bz2:append = ";\
	cd ${DEPLOY_DIR_IMAGE}; \
	mkdir -p ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}; \
	mv -f ${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.tar.bz2 ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/rootfs.tar.bz2; \
	echo ${IMAGE_NAME} > ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/imageversion; \
	echo "dummy file do not delete" > ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/${KERNEL_FILE}; \
	zip ${IMAGE_NAME}.zip ${IMAGEDIR}/*; \
	rm -Rf ${IMAGEDIR}; \
	cd ${IMGDEPLOYDIR}; \
	"

MTD_ROOTFS = "mmcblk0p1"
MTD_KERNEL = "mmcblk0p1"
ROOTFS_FILE = "rootfs.tar.bz2"
MTD_BLACK  = "mmcblk0"
