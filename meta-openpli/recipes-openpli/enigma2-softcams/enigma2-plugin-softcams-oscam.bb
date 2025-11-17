require oscam-common.inc

SRC_ORIGIN ?= "git://git.streamboard.tv/common/oscam.git;protocol=https;branch=master"

CAMTITLE = "OSCam ${PV}: Open Source Softcam"
CAMNAME = "oscam"

RDEPENDS:${PN} += "enigma2-plugin-softcams-oscam-whitelist enigma2-plugin-extensions-oscamstatus"
