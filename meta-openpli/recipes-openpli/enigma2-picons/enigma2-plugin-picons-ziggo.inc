inherit gitpkgv allarch

PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"

FILES:${PN} = "picon"
do_install() {
	install -d ${D}/picon
	cp  -R ${S}/picons/* ${D}/picon/
}


