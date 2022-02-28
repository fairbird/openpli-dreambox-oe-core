inherit image_types

CONVERSION_CMD_xz = "xz -f -k -c ${XZ_COMPRESSION_LEVEL} ${XZ_DEFAULTS} --check=${XZ_INTEGRITY_CHECK} ${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.${type} > ${IMAGE_NAME}_flash.${type}.xz"
