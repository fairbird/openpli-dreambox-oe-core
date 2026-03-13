SUMMARY = "The Ultimate Packer for eXecutables."
DESCRIPTION = "Executable packer for several executable formats."
HOMEPAGE = "https://upx.github.io"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=353753597aa110e0ded3508408c6374a"

SRC_URI = "https://github.com/upx/upx/releases/download/v${PV}/upx-${PV}-src.tar.xz"
SRC_URI[sha256sum] = "8eb914115b306fd9fd2110bd3d27ddb8ae7c5a03bb965f7d10f046a3a4ff9dfe"

S = "${UNPACKDIR}/upx-${PV}-src"

do_install(){
    install -d ${D}${bindir}
    install -m 0755 ${S}/build/release/upx ${D}${bindir}/
}

CLEANBROKEN = "1"

BBCLASSEXTEND = "native"
