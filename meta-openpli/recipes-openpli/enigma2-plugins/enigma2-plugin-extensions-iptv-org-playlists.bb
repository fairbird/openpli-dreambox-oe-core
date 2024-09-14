DESCRIPTION = "Tool to create bouquets based on playlists from github.com/iptv-org"
MAINTAINER = "Huevos"
HOMEPAGE = "https://github.com/Huevos/iptv-org-playlists-plugin-for-enigma2"

inherit gitpkgv allarch ${PYTHON_PN}native gettext

require conf/license/license-gplv2.inc

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/Huevos/iptv-org-playlists-plugin-for-enigma2.git;protocol=https;branch=master"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-requests \
    "

S = "${WORKDIR}/git"

pluginpath = "/usr/lib/enigma2/python/Plugins/Extensions/iptv-org-playlists"

do_install:append() {
	install -d ${D}${pluginpath}
	cp -r ${S}/src/* ${D}${pluginpath}/
	python3 -m compileall -o2 -b ${D}
	if [ -f /usr/bin/msgfmt ] ; then
		find ${S}/po/ -maxdepth 1 -type f -name '*.po' | while read po ; do
			## remove everything before and including the "/"
			filename=${po##*/}
			## remove everything after and including the "."
			cc=${filename%%.*}
			folder=${D}${pluginpath}/locale/${cc}/LC_MESSAGES
			mkdir -p ${folder}
			/usr/bin/msgfmt -o ${folder}/iptv-org-playlists.mo ${po}
		done
	fi
}

FILES:${PN} = "${pluginpath}/"

FILES:${PN}-src = "${pluginpath}/*.py"
