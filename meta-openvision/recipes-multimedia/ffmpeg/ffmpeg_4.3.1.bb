SUMMARY = "A complete, cross-platform solution to record, convert and stream audio and video."
DESCRIPTION = " FFmpeg is the leading multimedia framework, able to decode, encode, transcode, \
				mux, demux, stream, filter and play pretty much anything that humans and machines \
				have created. It supports the most obscure ancient formats up to the cutting edge."
HOMEPAGE = "https://www.ffmpeg.org/"
SECTION = "libs"

LICENSE = "BSD & GPLv2+ & LGPLv2.1+ & MIT"
LICENSE_${PN} = "GPLv2+"
LICENSE_libavcodec		= "${@bb.utils.contains('PACKAGECONFIG', 'gpl', 'GPLv2+', 'LGPLv2.1+', d)}"
LICENSE_libavdevice 	= "${@bb.utils.contains('PACKAGECONFIG', 'gpl', 'GPLv2+', 'LGPLv2.1+', d)}"
LICENSE_libavfilter		= "${@bb.utils.contains('PACKAGECONFIG', 'gpl', 'GPLv2+', 'LGPLv2.1+', d)}"
LICENSE_libavformat		= "${@bb.utils.contains('PACKAGECONFIG', 'gpl', 'GPLv2+', 'LGPLv2.1+', d)}"
LICENSE_libavresample	= "${@bb.utils.contains('PACKAGECONFIG', 'gpl', 'GPLv2+', 'LGPLv2.1+', d)}"
LICENSE_libavutil 		= "${@bb.utils.contains('PACKAGECONFIG', 'gpl', 'GPLv2+', 'LGPLv2.1+', d)}"
LICENSE_libpostproc 	= "GPLv2+"
LICENSE_libswresample 	= "${@bb.utils.contains('PACKAGECONFIG', 'gpl', 'GPLv2+', 'LGPLv2.1+', d)}"
LICENSE_libswscale 		= "${@bb.utils.contains('PACKAGECONFIG', 'gpl', 'GPLv2+', 'LGPLv2.1+', d)}"
LICENSE_FLAGS 			= "commercial"

LIC_FILES_CHKSUM = "file://COPYING.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
					file://COPYING.GPLv3;md5=d32239bcb673463ab874e80d47fae504 \
					file://COPYING.LGPLv2.1;md5=bd7a443320af8c812e4c18d1b79df004 \
					file://COPYING.LGPLv3;md5=e6a600fd5e1d9cbde2d983680233ad02 \
					"

SRC_URI = "git://github.com/FFmpeg/FFmpeg.git \
"

SRC_URI_append = "\
		file://02-fix-hls.patch \
		file://03-buffer-size.patch \
		file://04-aac.patch \
		file://05-fix-mpegts.patch \
		file://06-allow_to_choose_rtmp_impl_at_runtime.patch \
		file://07-fix-edit-list-parsing.patch \
		file://08-hls-replace-key-uri.patch;apply=no \
		"

S = "${WORKDIR}/git"

inherit gitpkgv autotools pkgconfig

PV = "4.3.1+git${SRCPV}"
PKGV = "4.3.1+git${GITPKGV}"

# Build fails when thumb is enabled: https://bugzilla.yoctoproject.org/show_bug.cgi?id=7717
ARM_INSTRUCTION_SET = "arm"

# Should be API compatible with libav (which was a fork of ffmpeg)
# libpostproc was previously packaged from a separate recipe
PROVIDES = "libav libpostproc"

RDEPENDS_${PN} = "libbluray rtmpdump libxml2 openssl"
DEPENDS = "alsa-lib zlib libogg nasm-native libxml2"

PACKAGECONFIG = "avdevice avfilter avcodec avformat avresample swscale swresample postproc \
				 bzlib gpl x264 openssl libbluray libfreetype librtmp mp3lame theora libvorbis lzma vpx \
				"

# libraries to build in addition to avutil
PACKAGECONFIG[avdevice]		= "--enable-avdevice,--disable-avdevice"
PACKAGECONFIG[avfilter]		= "--enable-avfilter,--disable-avfilter"
PACKAGECONFIG[avcodec]		= "--enable-avcodec,--disable-avcodec"
PACKAGECONFIG[avformat]		= "--enable-avformat,--disable-avformat"
PACKAGECONFIG[swresample]	= "--enable-swresample,--disable-swresample"
PACKAGECONFIG[swscale]		= "--enable-swscale,--disable-swscale"
PACKAGECONFIG[postproc]		= "--enable-postproc,--disable-postproc"
PACKAGECONFIG[avresample]	= "--enable-avresample,--disable-avresample"

# features to support
PACKAGECONFIG[bzlib]		= "--enable-bzlib,--disable-bzlib,bzip2"
PACKAGECONFIG[gpl]			= "--enable-gpl,--disable-gpl"
PACKAGECONFIG[gsm]			= "--enable-libgsm,--disable-libgsm,libgsm"
PACKAGECONFIG[jack]			= "--enable-indev=jack,--disable-indev=jack,jack"
PACKAGECONFIG[libbluray]	= "--enable-libbluray --enable-protocol=bluray,--disable-libbluray,libbluray"
PACKAGECONFIG[libfontconfig]= "--enable-libfontconfig,--disable-libfontconfig,fontconfig"
PACKAGECONFIG[libfreetype]	= "--enable-libfreetype,--disable-libfreetype,freetype"
PACKAGECONFIG[librtmp]		= "--enable-librtmp,--disable-librtmp,rtmpdump"
PACKAGECONFIG[libvorbis]	= "--enable-libvorbis,--disable-libvorbis,libvorbis"
PACKAGECONFIG[lzma]			= "--enable-lzma,--disable-lzma,xz"
PACKAGECONFIG[mp3lame]		= "--enable-libmp3lame,--disable-libmp3lame,lame"
PACKAGECONFIG[openssl]		= "--enable-openssl,--disable-openssl,openssl"
PACKAGECONFIG[speex]		= "--enable-libspeex,--disable-libspeex,speex"
PACKAGECONFIG[theora]		= "--enable-libtheora,--disable-libtheora,libtheora"
PACKAGECONFIG[vaapi]		= "--enable-vaapi,--disable-vaapi,libva"
PACKAGECONFIG[vdpau]		= "--enable-vdpau,--disable-vdpau,libvdpau"
PACKAGECONFIG[vpx]			= "--enable-libvpx,--disable-libvpx,libvpx"
PACKAGECONFIG[x11]			= "--enable-x11grab"
PACKAGECONFIG[x264]			= "--enable-libx264,--disable-libx264,x264"
PACKAGECONFIG[xv]			= "--enable-outdev=xv,--disable-outdev=xv,libxv"

# Check codecs that require --enable-nonfree
USE_NONFREE = "${@bb.utils.contains_any('PACKAGECONFIG', [ 'openssl' ], 'yes', '', d)}"

def cpu(d):
     for arg in (d.getVar('TUNE_CCARGS') or '').split():
        if arg.startswith('-mcpu='):
         return arg[6:]
     return 'generic'

EXTRA_OECONF = " \
	--disable-stripping \
	--enable-pic \
	--enable-shared \
	--enable-pthreads \
	${@bb.utils.contains('USE_NONFREE', 'yes', '--enable-nonfree', '', d)} \
	\
	--cross-prefix=${TARGET_PREFIX} \
	\
	--ld="${CCLD}" \
	--cc="${CC}" \
	--cxx="${CXX}" \
	--arch=${TARGET_ARCH} \
	--target-os="linux" \
	--enable-cross-compile \
	--extra-cflags="${CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
	--extra-ldflags="${LDFLAGS}" \
	--sysroot="${STAGING_DIR_TARGET}" \
	--enable-hardcoded-tables \
	${EXTRA_FFCONF} \
	--libdir=${libdir} \
	--shlibdir=${libdir} \
	--datadir=${datadir}/ffmpeg \
	--pkg-config="pkg-config" \
	${@bb.utils.contains('AVAILTUNES', 'mips32r2', '', '--disable-mipsdsp --disable-mipsdspr2', d)} \
	--cpu=${@cpu(d)} \
"

EXTRA_OECONF_append_linux-gnux32 = " --disable-asm"

do_configure() {
	${S}/configure ${EXTRA_OECONF}
}

PACKAGES =+ "	libavcodec \
				libavdevice \
				libavfilter \
				libavformat \
				libavresample \
				libavutil \
				libpostproc \
				libswresample \
				libswscale \
				"

FILES_libavcodec		= "${libdir}/libavcodec${SOLIBS}"
FILES_libavdevice		= "${libdir}/libavdevice${SOLIBS}"
FILES_libavfilter		= "${libdir}/libavfilter${SOLIBS}"
FILES_libavformat		= "${libdir}/libavformat${SOLIBS}"
FILES_libavresample		= "${libdir}/libavresample${SOLIBS}"
FILES_libavutil			= "${libdir}/libavutil${SOLIBS}"
FILES_libpostproc		= "${libdir}/libpostproc${SOLIBS}"
FILES_libswresample		= "${libdir}/libswresample${SOLIBS}"
FILES_libswscale		= "${libdir}/libswscale${SOLIBS}"

# ffmpeg disables PIC on some platforms (e.g. x86-32)
INSANE_SKIP_${MLPREFIX}libavcodec		= "textrel"
INSANE_SKIP_${MLPREFIX}libavdevice		= "textrel"
INSANE_SKIP_${MLPREFIX}libavfilter		= "textrel"
INSANE_SKIP_${MLPREFIX}libavformat		= "textrel"
INSANE_SKIP_${MLPREFIX}libavutil		= "textrel"
INSANE_SKIP_${MLPREFIX}libavresample	= "textrel"
INSANE_SKIP_${MLPREFIX}libswscale		= "textrel"
INSANE_SKIP_${MLPREFIX}libswresample	= "textrel"
INSANE_SKIP_${MLPREFIX}libpostproc		= "textrel"

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
	--extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS} -ffunction-sections -fdata-sections -fno-aggressive-loop-optimizations" \
	--extra-ldflags="${TARGET_LDFLAGS},--gc-sections -Wl,--print-gc-sections,-lrt" \
	--prefix=${prefix} \
"
