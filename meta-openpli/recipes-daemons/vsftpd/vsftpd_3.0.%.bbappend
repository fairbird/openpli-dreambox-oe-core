FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://login-blank-password.patch"

INITSCRIPT_PACKAGES = ""


CFLAGS += "-std=gnu17"
LDFLAGS:append = " -lssl -lcrypto"

do_install:append() {
	rm ${D}${sysconfdir}/init.d/vsftpd
	rm ${D}${sysconfdir}/vsftpd.ftpusers
	rm ${D}${sysconfdir}/vsftpd.user_list
}

pkg_postinst_ontarget:${PN}:append () {
#!/bin/sh
chown root /etc/vsftpd.conf
}

