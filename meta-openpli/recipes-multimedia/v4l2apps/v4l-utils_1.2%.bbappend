inherit autotools-brokensep
DEPENDS:append:class-target = " udev"
LDFLAGS:append = " -pthread"

INSANE_SKIP = "32bit-time"
