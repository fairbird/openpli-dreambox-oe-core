FILESEXTRAPATHS:prepend := "${THISDIR}/glib-2.0:"

PV = "2.87.1"

SRC_URI[archive.sha256sum] = "fc2ce0f948ee163f8adc5bdde2f38612b8a3f270022aa1b0d087cb9f1f0ac5c2"

SRC_URI:remove = "file://CVE-2026-0988.patch"
