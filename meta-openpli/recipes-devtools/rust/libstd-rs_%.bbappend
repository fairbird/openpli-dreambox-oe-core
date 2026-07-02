do_compile:prepend() {
    export RUSTC_BOOTSTRAP="1"

    TARGET_JSON="${WORKDIR}/rust-targets/${RUST_TARGET_SYS}.json"

    if [ -f "${TARGET_JSON}" ]; then
        grep -q '"llvm-abiname"' "${TARGET_JSON}" || \
            sed -i '/"arch"[[:space:]]*:[[:space:]]*"mips"/a\    "llvm-abiname": "o32",' "${TARGET_JSON}"
    fi
}

do_install () {
    mkdir -p ${D}${rustlibdir}

    rm -f ${B}/target/${RUST_TARGET_SYS}/${BUILD_DIR}/deps/*.d
    cp -r ${B}/target/${RUST_TARGET_SYS}/${BUILD_DIR}/deps/* ${D}${rustlibdir}
}
