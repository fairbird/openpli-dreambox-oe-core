do_install_append() {
    find ${D}/ -name '*.pyc' -exec rm {} \;
    find ${D}/ -name '*.egg-info' -exec rm {} \;
    # make scripts executable
    find "${D}" -name '*.sh' -exec chmod a+x '{}' ';'
}

install_egg_info() {
}
