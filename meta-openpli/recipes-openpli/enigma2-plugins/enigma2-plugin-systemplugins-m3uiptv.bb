DESCRIPTION = "IPTV m3u list dynamic reader and runner"
MAINTAINER = "DimitarCC"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
HOMEPAGE = "https://github.com/DimitarCC"

RDEPENDS:${PN} = "python3-multiprocessing python3-requests python3-zoneinfo"

inherit gitpkgv allarch gettext setuptools3-openplugins python3-compileall

PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/DimitarCC/iptv-m3u-reader.git;protocol=https;branch=main"

RRECOMMENDS:${PN} = "enigma2-plugin-extensions-tmbd"

S = "${WORKDIR}/git"

FILES:${PN}-src = "${pluginpath}/*.py"
