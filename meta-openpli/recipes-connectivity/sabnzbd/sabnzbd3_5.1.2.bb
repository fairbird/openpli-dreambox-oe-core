SUMMARY = "SABnzbd - The automated Usenet download tool"
DESCRIPTION = "SABnzbd is an Open Source Binary Newsreader written in Python."
HOMEPAGE = "https://sabnzbd.org"
MAINTAINER = "team@sabnzbd.org"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=72328159a86419c3e2ef6418eb56bcae"

RDEPENDS:${PN} = "\
	python3-cheetah python3-compression python3-core python3-crypt python3-ctypes python3-email python3-html \
	python3-misc python3-multiprocessing python3-sqlite3 python3-shell python3-sabyenc3 python3-configobj \
	python3-cryptography python3-feedparser python3-cheroot python3-cherrypy python3-portend python3-chardet \
	python3-notify2 python3-puremagic python3-guessit python3-sgmllib3k python3-more-itertools python3-modules \
	python3-rebulk python3-babelfish python3-dateutil python3-pysocks python3-jaraco.context python3-setuptools \
	python3-jaraco.functools python3-jaraco.collections python3-jaraco.text python3-jaraco.classes python3-sabctools python3-apprise \
	python3-pytz python3-tempora python3-zc.lockfile python3-six python3-pycparser python3-cffi python3-ct3 python3-rarfile \
	python3-charset-normalizer\
	"

RRECOMMENDS:${PN} = "par2cmdline unrar 7zip-full"

SRC_URI = "https://github.com/sabnzbd/sabnzbd/releases/download/${PV}/SABnzbd-${PV}-src.tar.gz \
    file://sabnzbd \
    file://sabnzbd.conf \
    file://init-functions \
    "

SRC_URI[md5sum] = "c72759d062fad4976687316306b3154f"
SRC_URI[sha256sum] = "bdf1ed947d810b5ac01a2b43b7f39cd11ca6eb6a93b577244a3c021d018d63e4"

S = "${UNPACKDIR}/SABnzbd-${PV}"

INSTALLDIR = "${libdir}/${PN}"

PACKAGES = "${PN}-doc ${PN}-src ${PN}"

FILES:${PN}-src = "${INSTALLDIR}/*/*.py ${INSTALLDIR}/*/*/*.py"
FILES:${PN}-doc = "${INSTALLDIR}/*.txt ${INSTALLDIR}/licenses ${INSTALLDIR}/interfaces/*/licenses"
FILES:${PN} = "${INSTALLDIR} /etc/init.d/sabnzbd /etc/init.d/init-functions /etc/enigma2/sabnzbd.conf"

inherit update-rc.d python3-compileall
INITSCRIPT_NAME = "sabnzbd"
INITSCRIPT_PARAMS = "defaults"

do_install() {
    install -d ${D}${INSTALLDIR}
    cp -r . ${D}${INSTALLDIR}/
    rm -rf ${D}${INSTALLDIR}/.git
    install -d ${D}/etc/init.d
    install -m 755 ${UNPACKDIR}/sabnzbd ${D}/etc/init.d/sabnzbd
    install -m 755 ${UNPACKDIR}/init-functions ${D}/etc/init.d/init-functions
    install -d ${D}/etc/enigma2
    install -m 644 ${UNPACKDIR}/sabnzbd.conf ${D}/etc/enigma2/sabnzbd.conf
}

do_install:append() {
	chmod 777 ${D}${INSTALLDIR}/SABnzbd.py
}
