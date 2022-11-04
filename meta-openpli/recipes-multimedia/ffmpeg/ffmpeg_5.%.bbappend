FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = " \
           file://02-fix-hls.patch \
           file://03-buffer-size.patch \
           file://04-aac.patch \
           file://05-fix-mpegts.patch \
           file://06-allow_to_choose_rtmp_impl_at_runtime.patch \
           file://07-fix-edit-list-parsing.patch \
           file://08-hls-replace-key-uri.patch \
           "

S = "${WORKDIR}/git"

PACKAGECONFIG:append = " gpl libbluray libfreetype librtmp openssl x264"

PACKAGECONFIG[libbluray] = "--enable-libbluray --enable-protocol=bluray,--disable-libbluray,libbluray"
PACKAGECONFIG[libfreetype] = "--enable-libfreetype,--disable-libfreetype,freetype"
PACKAGECONFIG[librtmp] = "--enable-librtmp,--disable-librtmp,librtmp rtmpdump"
PACKAGECONFIG[libv4l2] = "--enable-libv4l2,--disable-libv4l2,v4l-utils"

MIPSFPU = "${@bb.utils.contains('TARGET_FPU', 'soft', '--disable-mipsfpu', '--enable-mipsfpu', d)}"

EXTRA_FFCONF = " \
	--disable-static \
	--disable-runtime-cpudetect \
	--enable-ffprobe \
	--disable-altivec \
	--disable-amd3dnow \
	--disable-amd3dnowext \
	--disable-mmx \
	--disable-mmxext \
	--disable-sse \
	--disable-sse2 \
	--disable-sse3 \
	--disable-ssse3 \
	--disable-sse4 \
	--disable-sse42 \
	--disable-avx \
	--disable-xop \
	--disable-fma3 \
	--disable-fma4 \
	--disable-avx2 \
	--enable-inline-asm \
	--enable-asm \
	--disable-x86asm \
	--disable-fast-unaligned \
	--enable-muxers \
	--enable-encoders \
	--enable-decoders \
	--enable-demuxers \
	--enable-parsers \
	--enable-bsfs \
	--enable-protocols \
	--enable-indevs \
	--enable-outdevs \
	--enable-filters \
	--disable-doc \
	--disable-htmlpages \
	--disable-manpages \
	--disable-podpages \
	--disable-txtpages \
	--disable-vfp \
	--disable-neon \
	--disable-debug \
	--pkg-config="pkg-config" \
	--enable-zlib \
	--prefix=${prefix} \
	${@bb.utils.contains("TARGET_ARCH", "mipsel", "${MIPSFPU} --extra-libs=-latomic --disable-mips32r5 --disable-mipsdsp --disable-mipsdspr2 \
                             --disable-loongson2 --disable-loongson3 --disable-mmi --disable-msa --disable-msa2", "", d)} \
	${@bb.utils.contains("TARGET_ARCH", "arm", "--enable-armv6 --enable-armv6t2 --enable-vfp --enable-neon", "", d)} \
	${@bb.utils.contains("TUNE_FEATURES", "aarch64", "--enable-armv8 --enable-vfp --enable-neon", "", d)} \
"
