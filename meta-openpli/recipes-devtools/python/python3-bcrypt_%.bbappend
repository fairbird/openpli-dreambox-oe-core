include python3-package-split.inc

do_compile:prepend:mipsel() {
    export RUSTC_BOOTSTRAP="1"

    TARGET_JSON="${WORKDIR}/rust-targets/${RUST_TARGET_SYS}.json"

    if [ -f "${TARGET_JSON}" ]; then
        grep -q '"llvm-abiname"' "${TARGET_JSON}" || \
            sed -i '/"arch"[[:space:]]*:[[:space:]]*"mips"/a\    "llvm-abiname": "o32",' "${TARGET_JSON}"
    fi
}
