IMAGE_CMD:jffs2:prepend = " \
	rm -rf ${IMAGE_ROOTFS}/tmp/*; \
	mkfs.jffs2 \
		--root=${IMAGE_ROOTFS}/boot \
		--compression-mode=none \
		--output=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.boot.jffs2 \
		${EXTRA_IMAGECMD}; \
	rm -rf ${IMAGE_ROOTFS}/boot/*; \
	mkfs.jffs2 \
		--root=${IMAGE_ROOTFS} \
		--disable-compressor=lzo \
		--compression-mode=size \
		--output=${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.jffs2 \
		${EXTRA_IMAGECMD}; \
	${DREAMBOX_BUILDIMAGE} \
		--boot-partition ${DREAMBOX_PART0_SIZE}:${DEPLOY_DIR_IMAGE}/secondstage-${MACHINE}.bin \
		--data-partition ${DREAMBOX_PART1_SIZE}:${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.boot.jffs2 \
		--data-partition ${DREAMBOX_PART2_SIZE}:${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.jffs2 \
		> ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${DMTYPE}.nfi; \
	rm -f ${DEPLOY_DIR_IMAGE}/*.zip; \
	zip -j ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${DMTYPE}_nfi.zip ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${DMTYPE}.nfi ${DEPLOY_DIR_IMAGE}/imageversion ${DEPLOY_DIR_IMAGE}/donate.txt; \
	rm -f ${DEPLOY_DIR_IMAGE}/*.nfi; \
"

IMAGE_CMD:ubifs:prepend = " \
	rm -Rf ${IMAGE_ROOTFS}/tmp/*; \
	mkfs.jffs2 \
		--root=${IMAGE_ROOTFS}/boot \
		--compression-mode=none \
		--output=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.boot.jffs2 \
		${EXTRA_IMAGECMD}; \
	rm -rf ${IMAGE_ROOTFS}/boot/*; \
	echo \[root\] > ubinize.cfg; \
	echo mode=ubi >> ubinize.cfg; \
	echo image=${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ubifs >> ubinize.cfg; \
	echo vol_id=0 >> ubinize.cfg; \
	echo vol_name=${UBI_VOLNAME} >> ubinize.cfg; \
	echo vol_type=dynamic >> ubinize.cfg; \
	if [ ${UBINIZE_VOLSIZE} = "0" ]; then \
		echo vol_flags=autoresize >> ubinize.cfg; \
	else \
		echo vol_size=${UBINIZE_VOLSIZE} >> ubinize.cfg; \
		if [ ${UBINIZE_DATAVOLSIZE} != "0" ]; then \
			echo \[data\] >> ubinize.cfg; \
			echo mode=ubi >> ubinize.cfg; \
			echo vol_id=1 >> ubinize.cfg; \
			echo vol_type=dynamic >> ubinize.cfg; \
			echo vol_name=data >> ubinize.cfg; \
			echo vol_size=${UBINIZE_DATAVOLSIZE} >> ubinize.cfg; \
			echo vol_flags=autoresize >> ubinize.cfg; \
			printf '/dev/ubi0_1\t/data\t\tubifs\trw\t\t\t\t0 0\n' >> ${IMAGE_ROOTFS}/etc/fstab; \
			install -d ${IMAGE_ROOTFS}/data; \
		fi; \
	fi; \
	mkfs.ubifs \
		-r ${IMAGE_ROOTFS} \
		-o ${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ubifs \
		${MKUBIFS_ARGS}; \
	ubinize -o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ubi ${UBINIZE_ARGS} ubinize.cfg; \
	${DREAMBOX_BUILDIMAGE} \
		--boot-partition ${DREAMBOX_PART0_SIZE}:${DEPLOY_DIR_IMAGE}/secondstage-${MACHINE}.bin \
		--data-partition ${DREAMBOX_PART1_SIZE}:${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.boot.jffs2 \
		--data-partition ${DREAMBOX_PART2_SIZE}:${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ubi \
		> ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${DMTYPE}.nfi; \
	rm -f ${DEPLOY_DIR_IMAGE}/*.zip; \
	zip -j ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${DMTYPE}_nfi.zip ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${DMTYPE}.nfi ${DEPLOY_DIR_IMAGE}/imageversion ${DEPLOY_DIR_IMAGE}/donate.txt; \
	rm -f ${DEPLOY_DIR_IMAGE}/*.nfi; \
"

EXTRA_IMAGECMD:jffs2 ?= "-e ${DREAMBOX_ERASE_BLOCK_SIZE} -n -l"
EXTRA_IMAGECMD:ubifs ?= "-e ${DREAMBOX_ERASE_BLOCK_SIZE} -n -l"

do_image_jffs2[depends] += "dreambox-buildimage-native:do_populate_sysroot"
do_image_ubifs[depends] += "dreambox-buildimage-native:do_populate_sysroot"

IMAGE_TYPES += "jffs2 ubifs"
