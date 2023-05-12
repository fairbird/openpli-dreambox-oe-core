FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "57a9fd0841f00e92b478a07fef62636d7be612a8"

SRC_URI = "git://github.com/gabime/spdlog.git;protocol=https;branch=v1.x \
           file://fix-build-gerbera.patch \
"      
