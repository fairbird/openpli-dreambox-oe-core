# Fix: drv_enum.c uses udev functions - add libudev to DEPENDS
DEPENDS:append = " udev"

# Also add explicit CFLAGS to find libudev header
CFLAGS:append = " -I${STAGING_INCDIR}"
