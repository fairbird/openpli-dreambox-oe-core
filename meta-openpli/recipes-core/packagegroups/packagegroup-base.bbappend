# Patches on packagegroups to remove unwanted items

# Remove alsa-utils-alsamixer
#RDEPENDS_packagegroup-base-alsa = "\
#	alsa-utils-alsactl \
#	${VIRTUAL-RUNTIME_alsa-state} \
#"

RDEPENDS_packagegroup-base += "\
	stb-hwclock \
	fake-hwclock \
"
