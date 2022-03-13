# dreambox-mips32el-new.inc

KERNELVERSION = "3.4"

BOX_BRAND = "dreambox"

PREFERRED_PROVIDER_virtual/egl ?= "libvc5dream"
PREFERRED_PROVIDER_virtual/libgles1 ?= "libvc5dream"
PREFERRED_PROVIDER_virtual/libgles2 ?= "libvc5dream"
PREFERRED_PROVIDER_virtual/libgl ?= "mesa-gl"
PREFERRED_PROVIDER_virtual/mesa ?= "mesa-gl"

PREFERRED_VERSION_linux-dreambox = "${KERNELVERSION}"
PREFERRED_PROVIDER_jpeg ?= "libjpeg-turbo"
PREFERRED_PROVIDER_jpeg-native ?= "libjpeg-turbo-native"

DISTRO_FEATURES_GFX:mipsel ?= " opengl"

PACKAGECONFIG:pn-glmark2 = "gles2"

PACKAGECONFIG:pn-cogl-1.0 = "egl-kms egl-null \
        ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2', '', d)}"

PACKAGECONFIG:pn-weston = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles', '', d)}"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	libvc5dream \
	"

DREAMBOX_IMAGE_SIZE ??= "1024"

IMAGE_FSTYPES =+ "tar.xz"

IMAGE_CMD:tar:prepend = "\
	mkdir -p ${IMAGE_ROOTFS}/tmp; \
	rm -Rf ${IMAGE_ROOTFS}/tmp/*; \
	mkdir -p ${IMAGE_ROOTFS}${localstatedir}/lib/opkg/info; \
	echo "#!/bin/sh" > ${IMAGE_ROOTFS}${localstatedir}/lib/opkg/info/dreambox-secondstage.postinst; \
	echo "[ -n \"$D\" ] || flash-ssbl /usr/share/dreambox-secondstage/ssbl.bin" >> ${IMAGE_ROOTFS}${localstatedir}/lib/opkg/info/dreambox-secondstage.postinst; \
	chmod 777 ${IMAGE_ROOTFS}${localstatedir}/lib/opkg/info/dreambox-secondstage.postinst; \
	rm -f ${DEPLOY_DIR_IMAGE}/*.tar.xz; \
	"

MACHINE_FEATURES += "modem dvb-c blindscan-dvbc hdmicec recovery ci usbconsole HDMI"

IMAGE_CLASSES += "tarxz-dreambox"

KODIEXTSETTINGS = ""

KERNEL_FILE = "kernel.bin"
