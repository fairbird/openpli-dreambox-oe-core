CURRENT_FW = "central-two-noreset-200922-1.14.hex"

include nrf52-firmware.inc

COMPATIBLE_MACHINE = "^(dreamtwo)$"

RDEPENDS:${PN} += "flash-nrf52"
