include python3-package-split.inc

DEPENDS += "python3-wheel-native"

DISTUTILS_INSTALL_ARGS = " \
    --root=${D} \
    --install-lib=${PYTHON_SITEPACKAGES_DIR} \
"
