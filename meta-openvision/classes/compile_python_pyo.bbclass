do_compile_append() {
    ${PYTHONEXACTVERSION} -O -m compileall ${S}
}
