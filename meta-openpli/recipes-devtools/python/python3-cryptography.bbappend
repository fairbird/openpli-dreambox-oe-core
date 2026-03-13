DEPENDS:append = " python3-semantic-version-native"

PACKAGES =+ "${PN}-test"

include python3-package-split.inc
