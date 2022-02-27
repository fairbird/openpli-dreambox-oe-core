SUMMARY = "Setuptools Rust extension plugin"
HOMEPAGE = "https://github.com/PyO3/setuptools-rust"
AUTHOR = "Nikolay Kim <fafhrd91@gmail.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=011cd92e702dd9e6b1a26157b6fd53f5"

inherit pypi setuptools3

SRC_URI[sha256sum] = "647009e924f0ae439c7f3e0141a184a69ad247ecb9044c511dabde232d3d570e"

DEPENDS += "python3-wheel-native \
    python3-setuptools-scm-native \
"

RDEPENDS:${PN} = "\
    python3-json \
    python3-py \
    python3-setuptools \
    python3-toml \
"

RDEPENDS:${PN}:class-native = "\
    python3-setuptools-native \
    python3-toml-native \
"

BBCLASSEXTEND = "native nativesdk"
