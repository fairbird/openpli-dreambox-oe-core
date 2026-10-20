PACKAGE_ARCHS += " ocram"

do_compile:append_bcm7252s() {
    echo "arch armv7ahf-vfp-neon $priority" >> $archconf
    echo "arch armv7ahf-neon $priority" >> $archconf
}

do_compile:append_meson64() {
    echo "arch arch64 $priority" >> $archconf
}
