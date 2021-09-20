SUMMARY = "Flasher for NRF52 based BLE Transceiver"

SRC_URI = "http://dreamboxupdate.com/download/opendreambox/2.6.0/${PN}/${PV}/${PACKAGE_ARCH}/3649233eb10eaef04838f5021e0e4ca7/${PN}:${PV}_${PACKAGE_ARCH}.tar.xz"

SRC_URI[md5sum] = "3649233eb10eaef04838f5021e0e4ca7"
SRC_URI[sha256sum] = "e9f119af9bcadf4a74d91ed8ebccbf86bc423a2f38a32a46d7310cbea8fd8720"
SRC_URI[cortexa15hf-neon-vfpv4.md5sum] = "3649233eb10eaef04838f5021e0e4ca7"
SRC_URI[cortexa15hf-neon-vfpv4.sha256sum] = "e9f119af9bcadf4a74d91ed8ebccbf86bc423a2f38a32a46d7310cbea8fd8720"

COMPATIBLE_MACHINE = "^(dm900|dm920)$"

inherit opendreambox-precompiled-binary-new
