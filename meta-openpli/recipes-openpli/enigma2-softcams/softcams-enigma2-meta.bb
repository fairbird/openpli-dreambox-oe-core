DESCRIPTION = "meta file for enigma2 softcam packages"

require conf/license/openpli-gplv2.inc

PROVIDES = "softcams"

DEPENDS = " \
	${@bb.utils.contains("TARGET_ARCH", "mipsel armv7a", "enigma2-plugin-softcams-cccam", "", d)} \
	enigma2-plugin-softcams-oscam \
	enigma2-plugin-softcams-oscam-emu \
	enigma2-plugin-softcams-ncam \
	"
