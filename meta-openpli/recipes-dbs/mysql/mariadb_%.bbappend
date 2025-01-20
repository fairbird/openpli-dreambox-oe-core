do_install() {
    oe_runmake 'DESTDIR=${D}' install
    oe_multilib_header mysql/mariadb_version.h mysql/server/my_config.h mysql/server/private/config.h

    install -d ${D}/${sysconfdir}/init.d
    install -m 0644 ${UNPACKDIR}/my.cnf ${D}/${sysconfdir}/
    install -m 0755 ${UNPACKDIR}/install_db ${D}/${sysconfdir}/init.d/
    mv ${D}/${sysconfdir}/init.d/mysql ${D}/${sysconfdir}/init.d/mysqld

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${UNPACKDIR}/mysqld.service ${D}${systemd_unitdir}/system
    install -m 0644 ${UNPACKDIR}/install_db.service ${D}${systemd_unitdir}/system
    sed -i -e 's,@BINDIR@,${bindir},g' -e 's,@PREFIX@,${prefix},g' ${D}${systemd_unitdir}/system/mysqld.service \
                                                                   ${D}${systemd_unitdir}/system/install_db.service

    install -d ${D}${bindir}
    install -m 755 ${UNPACKDIR}/mysql-systemd-start ${D}${bindir}
    install -d ${D}${datadir}/doc/${PN}
    if [ -f ${D}${datadir}/doc/README ]; then
        mv ${D}${datadir}/doc/README ${D}${datadir}/doc/${PN}/
    fi

    # mini-benchmark used for Gitlab-CI to run on every commit to catch
    # if there are severe performance regressions.
    # remove it to avoid introducing bash dependency
    if [ -f ${D}${datadir}/mysql/mini-benchmark ]; then
        rm -rf ${D}${datadir}/mysql/mini-benchmark
    fi
    if ${@bb.utils.contains('DISTRO_FEATURES', 'pam', 'true', 'false', d)}; then
        pam_so=$(find ${D} -name pam_user_map.so)
        if [ x"${pam_so}" != x ]; then
            pam_dir=$(dirname ${pam_so})
            mv ${pam_dir} ${D}/${libdir}
            rmdir --ignore-fail-on-non-empty ${pam_dir%security}
        fi
    fi
}
