FILESEXTRAPATHS:prepend := "${THISDIR}/gcc:"

SRC_URI:append = " file://0001-Revert-Arm-Block-predication-on-atomics-PR111235.patch"
