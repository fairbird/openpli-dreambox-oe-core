FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://dmx_set_source.patch \
	file://audio_video_ioctl.patch \
"
