do_install() {
	cp -r  --preserve=mode,links ${S}${prefix} ${D}/
}
