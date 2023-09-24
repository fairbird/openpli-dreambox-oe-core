inherit setuptools3

# Scripts want to install "/etc", so we need "--root" instead of setting install-data stuff
# to remain compatible with previous versions.

SETUPTOOLS_INSTALL_ARGS = " \
	--root=${D} \
	--install-data=${datadir} \
	--install-lib=${libdir}/enigma2/python/Plugins \
"

setuptools3_do_install:append() {
	cd ${SETUPTOOLS_SETUP_PATH}
	install -d ${D}${PYTHON_SITEPACKAGES_DIR}
	${STAGING_BINDIR_NATIVE}/${PYTHON_PN}-native/${PYTHON_PN} setup.py \
	build --build-base=${B} install --skip-build ${SETUPTOOLS_INSTALL_ARGS} || \
	bbfatal_log "'${PYTHON_PN} setup.py install ${SETUPTOOLS_INSTALL_ARGS}' execution failed."
	# Remove "egg-info" files and site-packages
	rm -rf ${D}${libdir}/python${PYTHON_BASEVERSION}
	rm -rf ${D}${libdir}/enigma2/python/Plugins/*.egg-info
}

FILES:${PN} += "${libdir}"
