FILESEXTRAPATHS:append := "${THISDIR}/nodejs-22:"

# Only apply patch when building for ARM
SRC_URI:append:arm = " file://0001-arm-neon-cast-fix-llhttp.patch"
